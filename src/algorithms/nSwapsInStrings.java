package algorithms;
import java.util.*;
public class nSwapsInStrings {
/*
 * 1，有两个String， 只能判断它们是不是只有一组swap, e.g. EonSerVC, ConVerSE, 只要交换两个位置的S和V就行了, 这个只要pass一遍就行，然后问了复杂度O(n).
 * 2, follow up , 如果不只一组swap, 有多组swap怎么办，我说用hashmap，还是走一遍。
 * */
	public static void main(String[] args) {
		System.out.println(swapMore("ERnSeOVC", "COnVeRSE"));
	}
	
	private static boolean swapOnce(String s1, String s2) {
		if(s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length()) return false;
		int firstInd = -1, secondInd = -1;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(firstInd == -1) firstInd = i;
				else if(secondInd == -1) secondInd = i;
				else return false;
			}
		}
		return s1.charAt(firstInd) == s2.charAt(secondInd) && s2.charAt(firstInd) == s1.charAt(secondInd);
	}
	
	private static boolean swapMore(String s1, String s2) {
		if(s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length()) return false;
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				map.put(s1.charAt(i), i);
			}
		}
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(!map.containsKey(s2.charAt(i))) return false;
				int index = map.get(s2.charAt(i));
				if(s1.charAt(i) != s2.charAt(index) || s2.charAt(i) != s1.charAt(index)) return false;
			}
		}
		return true;
	}

}
