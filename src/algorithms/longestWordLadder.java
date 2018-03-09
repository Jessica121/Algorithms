package algorithms;
import java.util.*;
public class longestWordLadder {
	private static int res = 0;
	public static void main(String[] args) {
		Set<String> dic = new HashSet<>();
		// chat, hat, chats, bat.
//		dic.add("chat");
		dic.add("chats");
		dic.add("hat");
		dic.add("bat");
		longWL("at", dic, 1);
		System.out.println(res);
	}
	
	private static void longWL(String start, Set<String> dic, int len) {
		res = Math.max(res, len);
		System.out.println(start);
		StringBuilder sb = new StringBuilder(start);
		for(char c = 'a'; c <= 'z'; c++) {
			sb.insert(0, c);
			if(dic.contains(sb.toString())) {
				longWL(sb.toString(), dic, len + 1);
			}
			sb.deleteCharAt(0);
			sb.append(c);
			if(dic.contains(sb.toString())) {
				longWL(sb.toString(), dic, len + 1);
			}
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
