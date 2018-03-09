package algorithms;
import java.util.*;
public class longestWordLadder {
	private static int res = 0;
	public static void main(String[] args) {
		Set<String> dic = new HashSet<>();
		// chat, hat, chats, bat.
		dic.add("chat");
		dic.add("chats");
		dic.add("hat");
		dic.add("bat");
		
//		longWLRecursive("at", dic, 1);
//		System.out.println(res);
		System.out.println(longWLIter("at", dic));
	}
	
	private static void longWLRecursive(String start, Set<String> dic, int len) {
		res = Math.max(res, len);
		System.out.println(start);
		StringBuilder sb = new StringBuilder(start);
		for(char c = 'a'; c <= 'z'; c++) {
			sb.insert(0, c);
			if(dic.contains(sb.toString())) {
				longWLRecursive(sb.toString(), dic, len + 1);
			}
			sb.deleteCharAt(0);
			sb.append(c);
			if(dic.contains(sb.toString())) {
				longWLRecursive(sb.toString(), dic, len + 1);
			}
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static int longWLIter(String start, Set<String> dic) {
		int max = 0;
		Queue<String> que = new LinkedList<>();
		que.offer(start);
		int size = 0;
		while(!que.isEmpty()) {
			size = que.size();
			max++;
			for(int i = 0; i < size; i++) {
				StringBuilder sb = new StringBuilder(que.poll());
				for(char c = 'a'; c <= 'z'; c++) {
					sb.insert(0, c);
					if(dic.contains(sb.toString())) que.offer(sb.toString());
					sb.deleteCharAt(0);
					sb.append(c);
					if(dic.contains(sb.toString())) que.offer(sb.toString());
					sb.deleteCharAt(sb.length() - 1);
				}
			}
		}
		return max;
	}
}
