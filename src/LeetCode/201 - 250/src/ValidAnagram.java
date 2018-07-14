import java.util.*;
public class ValidAnagram {
    /*
    check equal length first;
    
    use a map, store s and its counts for each element.
    for each char in t, decrease the map count, return false if not found or cnt < 0.
    if not anagram, must be an entry that > 0 and one < 0, or multiple ones like this.
    
    r a t
    c -> not exist.
    
    aat
    aaa last a -> cnt < 0. 
    corner case: UNICODE, ASCII
    */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        computeS(s, map);
        for(int i = 0; i < t.length(); i++) {
            char cha = t.charAt(i);
            if(!map.containsKey(cha)) return false;
            map.put(cha, map.get(cha) - 1);
            if(map.get(cha) < 0) return false;
        }
        return true;
    }
    
    private void computeS(String s, Map<Character, Integer> map) {
        for(int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            map.put(cha, map.getOrDefault(cha, 0) + 1);
        }
    }
}
