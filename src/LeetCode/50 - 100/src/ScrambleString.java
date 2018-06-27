import java.util.*;
public class ScrambleString {
    /*
    BF: swap from index 1 to length - 2
    list of left swaps and right swaps, combine together, if it is the matched string, return true.
    or slightly optimized, check if both part not equal, swap.
    
    string concat is what makes it slow.
    **need to know that, the relationship is bi-directional. then could check from both sides.
    *and also the strucutre tree would also give you the hint that it is a subproblem - problem
    
    */
    public boolean isScrambleTLE(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        Map<String, List<String>> map = new HashMap<>();
        List<String> all = scramble(s1, map);        
        for(String s : all) if(s.equals(s2)) return true;
        return false;
    }
    
    private List<String> scramble(String s, Map<String, List<String>> map) {
        if(map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        if(s.length() == 0 || s.length() == 1) {
            res.add(s);
            return res;
        }
        
        for(int i = 1; i < s.length(); i++) {
            List<String> left = scramble(s.substring(0, i), map), right = scramble(s.substring(i), map);
            for(String r : right) {
                for(String l : left) {
                    res.add(r + l);
                    res.add(l + r);
                }
            }
        }
        map.put(s, res);
        return res;
    }
    
    
    /*
    main idea is to recursively use itself. 
    "rgeat" is a scrambled string of "great".
    rg and gr is true and eat and eat is true.
    so divide the total strings into substrings, check [s.substr(0, i), t.substr(0, i)] 
    rgtae" is a scrambled string of "great".
    tae and eat is => t and t, ae and ea. so reverse by the pivot.
    also check [s.substr(0, i) && t.substr(0, len - i)]
    
    */
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length() || !containsSameChars(s1, s2)) return false;
        if(s1.equals(s2)) return true;
        for(int i = 1; i < s1.length(); i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if(isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s1.length() - i))) return true;
        }
        return false;
    }
    
    private boolean containsSameChars(String s1, String s2) {
        int[] arr = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }
        // this is 26. wont work in ASCII thou
        for(int i = 0; i < 26; i++) {
            if(arr[i] != 0) return false;
        }
        return true;
    }
}
