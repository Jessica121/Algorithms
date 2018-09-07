import java.util.*;
public class WordPattern {
    /*
    i dont even know about this question: maybe i should get to fully understand the question before i proceed.
    so use two maps, bidirectional means check both side with exactly the same functionalities. could use a helper function for that.
    split the str, use an index to check the char in pattern and also serve as the index in the string array.
    check first map, char exist or not, if not put, if so check the value equal to current string or not.
    same as second string for the second map.
    could use bool existOrPut(map, key, value), check two maps, if either of them false, return false. else continue checking.
    until the index out of bound of the pattern.
    
    corner case is empty strings and / or diff length
    
    */
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split("\\s+");
        if(pattern.length() != arr.length) return false;
        int i = 0;
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        while(i < pattern.length()) {
            char cha = pattern.charAt(i);
            String string = arr[i];
            if(map1.containsKey(cha) && !map1.get(cha).equals(string) || (map2.containsKey(string) && map2.get(string) != cha)) return false;
            if(!map1.containsKey(cha)) map1.put(cha, string);
            if(!map2.containsKey(string)) map2.put(string, cha);
            i++;
        }
        return true;
    }
}
