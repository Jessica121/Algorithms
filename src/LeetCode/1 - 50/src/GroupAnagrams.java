import java.util.*;
public class GroupAnagrams {
    /*
    either sort the string (nlogn * m) or compress with the chars and letters as the key (m * n) 
    => the compressed stirng must be in sorted char order as well, need to know whether ASCII, UNICODE, or just lower case.
    use a map save list of strings of anagrams.
    output its values.
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String key = sort(str);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
    
    private String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
    
    /*
    either sort the string (nlogn * m) or compress with the chars and letters as the key (m * n)
    use a map save list of strings of anagrams.
    output its values.
    */
    public List<List<String>> groupAnagramsCompress(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String key = compress(str);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
    
    private String compress(String s) {
        int[] arr = new int[128];
        for(int i = 0; i < s.length(); i++) arr[s.charAt(i)]++;
        return Arrays.toString(arr);
    }
}
