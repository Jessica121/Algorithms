import java.util.*;

public class NewStringWithoutString2 {
	/*
	 * given two strings, str1, str2, return a new string that str1 does not contain any character in str2
	 * 
	 * String: UNICODE / ASCII
	 * 
	 * null string of either one: return str1
	 * 
	 * stringbuilder, one pointers, put str2 into set, if exist, advance ptr2 and ptr1 without adding to sb, else put the char in str1 in sb.
	 * 
	 * abcdefg, egg -> abcdf
	 * 
	 * if no extra space, sort the s2, binary search on it..
	 * use index of for each character on s2.
	 * 
	 * */
	
	// O(M + N)
	public static String deletChar(String s1, String s2) {
		if(s1.isEmpty() || s2.isEmpty()) return s1;
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < s2.length(); i++) set.add(s2.charAt(i));
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s1.length(); i++) {
			if(!set.contains(s1.charAt(i))) sb.append(s1.charAt(i));
		}
		return sb.toString();
	}
	
	// O(n * m)
	public static String deleteChar(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s1.length(); i++) {
			// when equals -1, means not found. != -1 means found.
			if(s2.indexOf(s1.charAt(i)) == -1) sb.append(s1.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(deleteChar("aaaaaaafaaa", "aaaaaaaa"));
	}

}
