import java.util.*;
public class SubstringWithConcatOfAllWords {
    /*
     * TLE
    concat all the strings in a permutation manner, check substring.
    use a set to track index have been added. back track remove the set index and take substring. (0, length() - concat.length())
    if set.size() is words.length, check substring in s, if not -1, add the index
    
    */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s.isEmpty() || words.length == 0) return res;
        Arrays.sort(words);
        build(res, s, words, new HashSet<>(), "");
        return res;
    }
    
    private void build(List<Integer> res, String s, String[] words, Set<Integer> set, String temp) {
        if(set.size() == words.length) {
            for(int i = 0; i <= s.length() - temp.length(); i++) {
                if(s.substring(i, i + temp.length()).equals(temp)) res.add(i);
            }
            return;
        }
        StringBuilder sb = new StringBuilder(temp);
        for(int i = 0; i < words.length; i++) {
            if(i > 0 && words[i].equals(words[i - 1]) && !set.contains(i - 1)) continue;
            if(!set.contains(i)) {
                set.add(i);
                sb.append(words[i]);
                build(res, s, words, set, sb.toString());
                sb = new StringBuilder(temp);
                set.remove(i);
            }
        }
    }
    
    /*
    since in the problem, each string has same length. we could know the formed string length.
    slide the formed string length string in the total string,
    check in the window, each length of block of string exist in the map and cnt not exceed it should be.
    else break. if j reached the end of the window, means valid, add the index i into res.
    do it till the end of totoal string.
	O(len of array * (s.length - len of array * len of word)
    */
    public List<Integer> findSubstringTwoPointer(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>(), cnt = new HashMap<>();
        buildMap(map, words);
        List<Integer> res = new ArrayList<>();
        if(s.isEmpty() || words.length == 0) return res;
        int time = words.length, len = words[0].length();
        for(int i = 0; i <= s.length() - len * time; i++) {
            String window = s.substring(i, i + len * time);
            cnt = new HashMap<>();
            int j = 0;
            for(; j <= len * time - len; j += len) {
                String subStr = window.substring(j, j + len);
                if(!map.containsKey(subStr)) break;
                cnt.put(subStr, cnt.getOrDefault(subStr, 0) + 1);
                if(cnt.get(subStr) > map.get(subStr)) break;
            }
            if(j == len * time) res.add(i);
        }
        return res;
    }
    
    private void buildMap(Map<String, Integer> map, String[] words) {
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }
}
