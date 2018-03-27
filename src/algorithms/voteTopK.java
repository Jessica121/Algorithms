package algorithms;
import java.util.*;
public class voteTopK {
	private static voteTopK instance = new voteTopK();
/*  输入是一个Vote的list，Vote是（time，name），和一个时间time；
	输出time之前票数最高的人。 
	
	follow up1：
	输入增加一项：k
	输出time之前票数top k 的人 
	
	follow up2：
	输入：Vote的list和candidate的List（List<String>)
	输出当candidate是top n时的最后时间；n = candidate.size()
	
	4. 给一堆根据票数多少排序的候选人list, 给一堆选票，求出哪个时间内可以从这堆选票中得出这堆给你的候选人的list.
	
	class LogEntry {
		string candidate; 投票姓名
		int time;
 	}
  	 string findWinner(int time, List<LogEntry> logs); 让找出在这个时间时候的 winner
	 c1(1), c2(2), c1(2), c2(3),c2(4) 括号里是投票时间。 所以
	 findWinner(2, logs) = c1;
	 findWinner(4, logs) = c2;
	 用的 hash 表。找出最多的那个(投票在此时间后的不算)
*/
	public static void main(String[] args) {
		list.add(instance.new LogEntry("c1", 1));
		list.add(instance.new LogEntry("c2", 2));
		list.add(instance.new LogEntry("c1", 2));
		list.add(instance.new LogEntry("c2", 3));
		list.add(instance.new LogEntry("c2", 4));
		list.add(instance.new LogEntry("c1", 4));
		list.add(instance.new LogEntry("c2", 5));
		list.add(instance.new LogEntry("c1", 5));
		list.add(instance.new LogEntry("c2", 6));
		list.add(instance.new LogEntry("c2", 7));
		for(int i = 1; i < 8; i++) {
			System.out.println(i + " " + findWinner(list, i, 2));
		}
		List<String> l1 = new ArrayList<>();
		l1.add("c1");
//		l1.add("c4");
		System.out.println(findTime(list, l1));
	}
	private static List<LogEntry> list = new ArrayList<>();
	
	class LogEntry {
		String candidate; 
		int time;
		public LogEntry(String n, int t) {
			time = t;
			candidate = n;
		}
 	}
	
	private static List<String> findWinner(List<LogEntry> list, int time, int k) {
		Map<String, Integer> map = new HashMap<>();
		// Sort the vote time from earlier to later
		Collections.sort(list, (a, b) -> (a.time - b.time));
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).time > time) break;
			map.put(list.get(i).candidate, map.getOrDefault(list.get(i).candidate, 0) + 1);
		}
		List<String> res = new ArrayList<>();
		res.addAll(map.keySet());
		Collections.sort(res, (a, b) -> (map.get(b) - map.get(a)));
		// Including the ties.
		while(res.size() > k && map.get(res.get(k - 1)) == map.get(res.get(k))) {
			k++;
		}
		// remove the rest
		while(res.size() > k) res.remove(res.size() - 1);
		return res;
	}
	// 相信自己
	private static int findTime(List<LogEntry> list, List<String> candi) {
		if(candi.size() > list.size()) return -1;
		Map<String, Integer> map = new HashMap<>();
		// o(nlogn) n -> num of votes
		Collections.sort(list, (a, b) -> (a.time - b.time));
		for(int i = 0; i < list.size(); i++) {
			map.put(list.get(i).candidate, map.getOrDefault(list.get(i).candidate, 0) + 1);
		}
		int i = list.size() - 1;
		// m (list size) * nlogn (n : map.size) = n^2logn
		while(i >= 0 && !topK(map, candi.size()).equals(candi)) {
			map.put(list.get(i).candidate, map.get(list.get(i).candidate) - 1);
			if(map.get(list.get(i).candidate) == 0) map.remove(list.get(i).candidate);
			i--;
			if(map.size() < candi.size()) return -1;
		}
		return list.get(i).time;
	}
	
	private static List<String> topK(Map<String, Integer> map, int k) {
		List<String> res = new ArrayList<>();
		res.addAll(map.keySet());
		// nlogn -> n : map size
		Collections.sort(res, (a, b) -> (map.get(b) - map.get(a)));
		while(res.size() > k) res.remove(res.size() - 1);
		return res;
	}

}
