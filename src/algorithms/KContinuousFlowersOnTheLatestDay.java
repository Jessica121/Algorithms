package algorithms;
import java.util.*;
public class KContinuousFlowersOnTheLatestDay {
	public static void main(String[] args) {
		int[] flow = {3,1,5,4,2};
		System.out.println(flower(flow, 0));
	}
	
	private static int flower(int[] P, int k) {
		boolean[] arr = new boolean[P.length];
		Map<Integer, List<Integer>> map = new HashMap<>();
		int day = 1, res = -1;
		// O(n^2)
		for(int p = 0; p < P.length; p++) {
			arr[P[p] - 1] = true;
			// O(n)
			List<Integer> len = consecutiveOnToday(arr);
			// O(k)
			for(int l : len) {
				map.computeIfAbsent(l, a -> new ArrayList<>()).add(day);
			}
			// BFS like : day only increase outter the loop
			day++;
		}
		if(!map.containsKey(k)) return res;
		else {
			List<Integer> days = map.get(k);
			// Get the max in O(m)
			for(int d : days) {
				res = Math.max(res, d);
			}
		}
		return res;
	}
	/*Calculate all consecutive flower number on this day*/
	private static List<Integer> consecutiveOnToday(boolean[] arr) {
		Set<Integer> set = new HashSet<>();
		List<Integer> len = new ArrayList<>();
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == true) cnt++;
			else{
				if(cnt == 0) continue;
				if(set.contains(cnt)) {
					cnt = 0;
					continue;
				}
				len.add(cnt);
				set.add(cnt);
				cnt = 0;
			}
		}
		if(cnt != 0 && !set.contains(cnt)) len.add(cnt);
		return len;
	}
}
