import java.util.*;

public class RepeatedDNASequence {
    /*
    use a sliding window, and track the occurence in a hashmap: string to integer
    window: i = 0 .. length() - 10. incl.
    then if the map.cnt == 1, add. else dont add. cuz no need to add when >= 2, when 2 is already added.
    
    */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
            if(map.get(str) == 2) res.add(str);
        }
        return res;
    }
}
