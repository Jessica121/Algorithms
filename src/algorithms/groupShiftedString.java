package algorithms;
import java.util.*;
public class groupShiftedString {
/*
 * Given a string, we can "shift" each of its letter to its successive letter, 
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
	"abc" -> "bcd" -> ... -> "xyz"
	Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
	
	For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
	A solution is:
	
	[
	  ["abc","bcd","xyz"],
	  ["az","ba"],
	  ["acef"],
	  ["a","z"]
	]
 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("abc");list.add("bcd");list.add("acef");list.add("xyz");list.add("az");list.add("ba");
		list.add("a");list.add("z");
		System.out.println(groupShiftedStr_bruteForce(list));
//		generate("a", list, new HashSet(list));
	}
	
	private static List<List<String>> groupShiftedStr_bruteForce(List<String> list) {
		Set<String> set = new HashSet<>(list);
		List<List<String>> res = new ArrayList<>();
		for(String s : list) {
			if(!set.contains(s)) continue;
			set.remove(s);
			List<String> l = new ArrayList<>();
			l.add(s);
			generate(s, l, set);
			res.add(l);
		}
		return res;
	}
	
	private static void generate(String s, List<String> l, Set<String> set) {
		StringBuilder sb = new StringBuilder();
//		System.out.println(s + " " + set);
		for(int j = 0; j <= 26; j++) {
// 			sb 重新清空			
			sb = new StringBuilder();
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) != 'z') sb.append((char)(s.charAt(i) + 1));
				else sb.append('a');	
			}
			if(set.contains(sb.toString())) {
				l.add(sb.toString());
				set.remove(sb.toString());
			}
			s = sb.toString();
		}
	}
	
	private static List<List<String>> groupShiftedStr_Count(List<String> list) {
		Map<String, List<String>> map = new HashMap<>();
		List<List<String>> res = new ArrayList<>();
		for(String s : list) {
			String rep = rep(s);
			map.computeIfAbsent(rep, k -> new ArrayList<>()).add(s);
		}
		for(String s: map.keySet()) {
			res.add(map.get(s));
		}
		return res;
	}
	
	private static String rep(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < s.length(); i++) {
			sb.append(s.charAt(i) - s.charAt(i - 1));
		}
		return sb.toString();
	}

}
