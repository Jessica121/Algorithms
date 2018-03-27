package algorithms;
import java.util.*;
public class synonyms {
/*
	给一系列同义词对 synonyms
	[["a", "b"], ["b", "c"], ["d", "e"]] --> a == b && b == c && d == e
	然后再给一系列 queries，判断是不是全都是同义词, return true or false
	["a"] ["c"] --> return true (a == b == c)
	["b", "c"] ["a", "d"] --> return false (b == a && c != d)
	

	给一个dic：(a, b) (c, d)
	(a, b)意思是a、b同义，可以互相转化。
	那么ac = bd, ac = ad, ac = ac
	问两个string是否相同。
 */
	public static void main(String[] args) {
		String[][] dict = {{"a", "b"}, {"b", "c"}, {"d", "e"}, {"a", "e"}};
		System.out.println(sameString("eb", "aa", dict));
	}
	
	private static boolean sameString(String s1, String s2, String[][] dict) {
		if(s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length()) return false;
		Map<String, List<String>> map = new HashMap<>();
		for(String[] pair : dict) {
			map.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
			map.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
		}
		System.out.println(map);
		for(int i = 0; i < s1.length(); i++) {
			Set<String> set = new HashSet<String>();
			// use a set, add and only add the start
			set.add(s1.substring(i, i + 1));
			if(!dfs(map, s1.substring(i, i + 1), s2.substring(i, i + 1), set)) return false;
		}
		return true;
	}
	
	private static boolean dfs(Map<String, List<String>> map, String s1, String s2, Set<String> set) {
		if(s1.equals(s2)) return true;
		if(!map.containsKey(s1) || !map.containsKey(s2)) return false;
		for(String child : map.get(s1)) {
			if(!set.contains(child)) {
				set.add(child);
				if(dfs(map, child, s2, set)) return true;
				set.remove(child);
			}
		}
		return false;
	}
}
