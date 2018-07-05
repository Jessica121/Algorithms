import java.util.*;
public class IsomorphicString {
    /*
    pretty intuitive..
    first instinct is to use a map, char to char. have a pointer go in both of the strings.
    if char in str1 exist in the map, check the char in str2 match the value in the map.
    else put the char1 and char2 in the map.
    
    corner case: empty string.
    two strings of different length. false.
    use a set to track the mapped value? omg
    */
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(t.charAt(i) != map.get(s.charAt(i))) return false;
            } else {
                if(set.contains(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
    }
}
