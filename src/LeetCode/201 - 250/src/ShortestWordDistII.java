import java.util.*;

public class ShortestWordDistII {
    /*
    use a map to record all occurence of words: indexes: mind this will make the list sorted.
    pick the two lists of two words:
    find the min dist:
    1,3,5,6,8
    2,4,7,9
    everytime, move smaller ones, calculate. till one of them is out of bounds. if the other ones remains, it must be everything is larger an no point continue to compare. so ptr1 < s1.length() && ptr2 < s2.length()
    
    corner case: when string1 and string2 not in the list.
    string1 equals string2
    */

    Map<String, List<Integer>> map;
    public ShortestWordDistII(String[] words) {
        map = new HashMap<>();
        constructMap(map, words);
    }
    
    private void constructMap(Map<String, List<Integer>> map, String[] words) {
        for(int i = 0; i < words.length; i++) {
            map.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        if(!map.containsKey(word1) || !map.containsKey(word2)) return -1;
        List<Integer> list1 = map.get(word1), list2 = map.get(word2);
        int ptr1 = 0, ptr2 = 0, res = Integer.MAX_VALUE;
        while(ptr1 < list1.size() && ptr2 < list2.size()) {
            int can1 = list1.get(ptr1), can2 = list2.get(ptr2);
            res = Math.min(res, Math.abs(can1 - can2));
            if(list1.get(ptr1) < list2.get(ptr2)) ptr1++;
            else ptr2++;
        }
        return res;
    }
}
