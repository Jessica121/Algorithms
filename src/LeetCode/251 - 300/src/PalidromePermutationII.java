import java.util.*;
public class PalidromePermutationII {
    /*
    first check canGeneratePalidrome with the string, if not return empty list
    get the map of count with each char, choose each one onely once with one pass.
    only add the cnt == 1 when string is empty.
    else add to front and append to end, if count >= 2, decrease the count in map by 2.
    backtrack with the string, then add it back.
    stop when generated string length equals s.length.
    
    pass in temp string, original lengh, list of string and map.
    
    */
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(!canGenerate(s, map)) return res;
        generate(s.length(), new StringBuilder(), map, res);
        return res;
    }
    
    private void generate(int len, StringBuilder sb, Map<Character, Integer> map, List<String> res) {
        if(sb.length() == len) {
            res.add(sb.toString());
            return;
        }
        String ori = sb.toString();
        for(char key : map.keySet()) {
        	// mind that when it does not have anymore counts, ignore.
            if(map.get(key) == 0) continue;
            // it could be aaa a : 3, so cannot just check when count == 1. check odd.
            if(map.get(key) % 2 != 0 && sb.length() == 0) {
                sb.append(key);
                map.put(key, map.get(key) - 1);
                generate(len, sb, map, res);
                map.put(key, map.get(key) + 1);
                sb = new StringBuilder(ori);
            } else if(map.get(key) % 2 == 0) {
                sb.append(key);
                sb.insert(0, key);
                map.put(key, map.get(key) - 2);
                generate(len, sb, map, res);
                map.put(key, map.get(key) + 2);
                sb = new StringBuilder(ori);
            }
        }
    }
    
    private boolean canGenerate(String s, Map<Character, Integer> map) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            map.put(cha, map.getOrDefault(cha, 0) + 1);
            if(map.get(cha) % 2 != 0) cnt++;
            else cnt--;
        }
        return cnt <= 1;
    }
}
