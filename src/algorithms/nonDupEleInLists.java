package algorithms;

import java.util.*;

public class nonDupEleInLists {
	/*
	 * 
	1. 给你两个list of string，两个list里都各自没有duplicate，然后找到其中只在一个list里出现的string。问了时间空间复杂度。
	a = [1,2,3]
	b = [2,4,6]. 
	return: [1,3,4,6]
	
	2. follow up 1：如果里面有duplicate呢。问了时间空间复杂度。
	比如：
	a = [1,2,3]
	b = [2,4,4,6]
	return: [1,3,4,6]
	
	3. follow up 2：如果给你一个list of list of string，random size，怎么写。
	比如：
	a = [1,2,3]
	b = [2,4,4,6]
	...
	n = [x,x,x,x]
	*/
	public static void main(String[] args) {
		// 1. 1 SET, if exist, remove it, if not, add it. return the set
		// 2. store string[] string : 1 / 2.
		// if exist, check mark, if same, ignore, if not, remove it.
		// if not exist, add. return the set.
		// 3. divide n conqur
		List<String> l1 = new ArrayList<>(), l2 = new ArrayList<>(), l3 = new ArrayList<>();
		List<List<String>> lists = new ArrayList<>();
		l1.add("1");l1.add("2");l1.add("3");
		l2.add("2");l2.add("4");l2.add("4");l2.add("6");
		l3.add("3");l3.add("5");l3.add("4");l3.add("5");
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		System.out.println(merge(lists));
	}
	
	private static List<String> uniqEle(List<String> l1, List<String> l2) {
		Map<String, Boolean> map = new HashMap<>();
		for(String s : l1) {
			map.put(s, true);
		}
		for(String s : l2) {
			if(!map.containsKey(s)) map.put(s, false);
			else {
				if(map.get(s) == true) map.remove(s);
			}
		}
		List<String> res = new ArrayList<>(map.keySet());
		return res;
	}
	
	private static List<String> merge(List<List<String>> lists) {
		return merge(lists, 0, lists.size() - 1);
	}
	
	private static List<String> merge(List<List<String>> lists, int s, int e) {
		if(s == e) return lists.get(s);
		int mid = s + (e - s) / 2;
		List<String> left = merge(lists, s, mid);
		List<String> right = merge(lists, mid + 1, e);
		return uniqEle(left, right);
	}

}
