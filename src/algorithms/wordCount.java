package algorithms;
import java.util.*;
public class wordCount {
/*
 * 第一部分: 先是给你两个list of strings(data structure不一定是list, 自己定义, 可以是array), 
 * 			找出在当中只出现在一个list中的string. 有可能一个string在一个list中会出现多次, 然后我就把vector转成哈希set.
 * 第二部分: 如果不只有两个list如何处理. 类似上面的解.
 * 第三部分: 如果不转成哈希set还能怎么解.
*/
	public static void main(String[] args) {
		// 1. put into a hashset, iterate thru the other, get the ones with that does not exist;
		// 2. use one set for the first list. the rest ( list 2 - )
		// use another temp set. if does not exist, add to the temp set. if exist, remove from the set
		// merge two set into main set.
		List<String> list1 = new ArrayList<>();
		list1.add("a");list1.add("b");list1.add("c");list1.add("d");
		List<String> list2 = new ArrayList<>();
		list2.add("e");list2.add("e");list2.add("e");list2.add("d");
		List<String> list3 = new ArrayList<>();
		list3.add("f");list3.add("g");list3.add("a");list3.add("a");
		List<String> list4 = new ArrayList<>();
		list4.add("a");list4.add("b");list4.add("c");list1.add("d");
		List<String> list5 = new ArrayList<>();
		list5.add("e");list5.add("e");list5.add("h");list2.add("d");
		List<String> list6 = new ArrayList<>();
		list6.add("f");list6.add("z");list6.add("a");list3.add("a");
		List<List<String>> lists = new ArrayList<>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		lists.add(list4);
		lists.add(list5);
		lists.add(list6);
		System.out.println(divideNConqur(lists, 0, lists.size() - 1));
	}
	
	private static Set<String> uniqWordOneByOne(List<List<String>> lists) {
		Set<String> set = new HashSet(), temp = new HashSet();
		for(int i = 0; i < lists.size(); i++) {
			temp = new HashSet(lists.get(i));
			//System.out.println("temp-> " + temp);
			for(String str : temp) {
//				System.out.println("str-> " + str);
				if(set.contains(str)) {
//					System.out.println("tep");
					set.remove(str); 
				} else set.add(str);
			}
//			System.out.println("set-> " + set);
		}
		return set;
	}
	
	private static List<String> divideNConqur(List<List<String>> lists,int s, int e) {
		if(s == e) return lists.get(s);
		int mid = s + (e - s) / 2;
		List<String> res1 = divideNConqur(lists, s, mid);
		List<String> res2 = divideNConqur(lists, mid + 1, e);
		return uniqWordTwo(res1, res2);
	}
	
	private static List<String> uniqWordTwo(List<String> list1, List<String> list2) {
		Set<String> set = new HashSet(list1), temp = new HashSet(list2);
		for(String s : temp) {
			if(set.contains(s)) {
				set.remove(s);
			} else set.add(s);
		}
		return new ArrayList<>(set);
	}

}
