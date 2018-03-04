package algorithms;
import java.util.*;
public class KContinuousFlowersOnTheLatestDay {
	public static void main(String[] args) {
		int[] flow = {5,4,3,2,1};
		System.out.println(flower(flow, 5));
	}
	
	private static int flower(int[] P, int k) {
		// On the last day must all bloom
		if(k == P.length) return P.length;
		TreeSet<Integer> set = new TreeSet<>();
		// Add "Walls"
		set.add(0);
		set.add(P.length + 1);
		// Flowers bloom -> empty slot in LC 683
		for(int i = P.length - 1; i >= 0 ; i--) {
			set.add(P[i]);
			Integer high = set.higher(P[i]);
			Integer low = set.lower(P[i]);
//			System.out.println("pi " + P[i] + " higher " + set.higher(P[i]) + " lower " + set.lower(P[i]) + " res " + (high - P[i] - 1) + " or " + (P[i] - low - 1));
			if(high != null && (high - P[i] - 1 == k) || low != null && (P[i] - low - 1 == k)) return i;
		}
		return -1;
	}
}
