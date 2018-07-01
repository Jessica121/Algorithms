import java.util.*;

public class WordBreak {
    /*
    for each start index, take substring, if contained in the dict, recursely call next, if true, add to map, true, return.
    since different start index may end up with same end index, which is the same start index for the next recursion call.
    so, save it.
    i dont understand why the input is a list instead of a set. like what is the point.
    
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> map = new HashMap<>();
        return check(s, 0, map, new HashSet<>(wordDict));
    }
    
    private boolean check(String s, int index, Map<Integer, Boolean> map, Set<String> set) {
        if(index == s.length()) return true;
        if(map.containsKey(index)) return map.get(index);
        for(int i = index + 1; i <= s.length(); i++) {
            if(set.contains(s.substring(index, i)) && check(s, i, map, set)) {
                map.put(index, true);
                return true;
            }
        }
        map.put(index, false);
        return false;
    }
}
