package algorithms;

public class minWindowBinarySum {
/*
 *  dp / two pointers -> Minimum window sum .0101010110 这样的序列，求一个min window使和等于target
 * 
 * */
	public static void main(String[] args) {
		// two pointers, both start from 0, increase the second one, until hit the target. then decrease the first one.
		// check the len on the fly and also start n end pointers.
		String s = "01010101110";
		System.out.println(minWindow(s, -99));
	}
	
	public static String minWindow(String s, int target) {
		int len = Integer.MAX_VALUE, p1 = 0, p2 = 0, left = 0, right = 0, sum = 0;
		while(p1 < s.length() && p2 < s.length()) {
			while(sum <= target && p2 < s.length()) {
				sum += s.charAt(p2++) - '0';
			}
			while(p1 < s.length() && target <= sum) {
				sum -= s.charAt(p1++) - '0';
				if(sum == target) {
					if(len > p2 - p1 + 1) {
						left = p1;
						right = p2;
						len = p2 - p1 + 1;
					}
				}
			}
		}
//		System.out.println(left + " " + right);
		return s.isEmpty() ? "" : s.substring(left, right);
	}

}
