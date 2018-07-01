import java.util.*;
public class WordBreakII {
    /*
    return a bounch of list at each index and append to the front with a blank space. duh. return
    if substring in the set, return the next index string. add all.
    
    */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap<>();
        return check(s, 0, map, new HashSet<>(wordDict));
    }
    
    private List<String> check(String s, int index, Map<Integer, List<String>> map, Set<String> set) {
        List<String> res = new ArrayList<>();
        if(index == s.length()) {
            res.add("");
            return res;
        }
        if(map.containsKey(index)) return map.get(index);
        for(int i = index + 1; i <= s.length(); i++) {
            String candi = s.substring(index, i);
            if(set.contains(candi)) {
                List<String> next = check(s, i, map, set);
                for(String str : next) res.add((candi + " " + str).trim());
            }
        }
        map.put(index, res);
        return res;
    }
}
