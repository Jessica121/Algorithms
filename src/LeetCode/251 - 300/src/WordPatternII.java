import java.util.*;
public class WordPatternII {
    /*
    seems like a backtracking problem for me.
    cache the results.
    try from index start to i, if pattern exist in map1 then try substring until equals to the value
    if cannot find, or the substring longer than the value, return false.
    if map1 does not have the char, then backtrack, add the char and the substring to map1
    since this is bidirectional, check the substring as well. if it exist in the map2, but value is not the current char, then dont use it. 
    1. map1 have the current char, find the right substring. is not possible when map2 have the substring but the char is not match, since it is bidirectional. must add both.
    2. map1 does not have the current char, but map2 have the current substring, only proceed when char matches as well.
    3. don't have it in either way, just backtrack, and put both maps.
    
    from start to length, check the substring and the start char as above.
    if recursively call next. if any of them return true, return true immediately, else remove the entries in the maps and proceed.
    
    if one of the subproblem is true, return true.
    base case is when i == length for both, so need two pointers. 
    a b c 
    a a a
    
    */
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        return check(0, 0, pattern, str, map1, map2);
    }
    
    private boolean check(int ind1, int ind2, String pattern, String str, Map<Character, String> map1, Map<String, Character> map2) {
        if(ind1 >= pattern.length() || ind2 >= str.length()) return ind1 == pattern.length() && ind2 == str.length();
        for(int i = ind2 + 1; i <= str.length(); i++) {
            char cha = pattern.charAt(ind1);
            String string = str.substring(ind2, i);
            if(map1.containsKey(cha)) {
                if(i - ind2 > map1.get(cha).length()) return false;
                // if exist in map1 or 2, but does not match, should skip, instead of check rest. else will go to "else" part.
                if(!string.equals(map1.get(cha))) continue;
                if(check(ind1 + 1, i, pattern, str, map1, map2)) return true;  
            } 
            if(map2.containsKey(string)) {
                if(cha != map2.get(string)) continue;
                if(check(ind1 + 1, i, pattern, str, map1, map2)) return true;
            } else {
                map1.put(cha, string);
                map2.put(string, cha);
                if(check(ind1 + 1, i, pattern, str, map1, map2)) return true;
                map1.remove(cha);
                map2.remove(string);
            }
        }
        return false;
    }
}
