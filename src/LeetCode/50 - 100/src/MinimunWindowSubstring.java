import java.util.*;
public class MinimunWindowSubstring {
    /*
     * 
     * Aperfect example of why duplicated char should not be affect the counter is : 
     * "aaaaaaaaaaa|abbbbbcdd"
     * "abcdd"
     * abbbb makes cnt equal t.length(), and a in the map is not < 0. but it may contain dup later.
    two pointers and a cnt, increase the cnt whenever meet a char in t. even if aaa => 3
    first pointer start to move when cnt >= t.length
    only move when the cnt in the arr > 1, then, decrease the arr value and cnt --;
    update the substring when cnt == t.length
    use a map to check if its in t or not.
    
    */
    public String minWindowWrong(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        saveT(map, t);
        String res = "";
        int ptr1 = 0, ptr2 = 0, cnt = 0;
        while(ptr2 < s.length()) {
            char cha = s.charAt(ptr2);
            if(!map.containsKey(cha)) ptr2++;
            else {
                map.put(cha, map.get(cha) - 1);
                cnt++;
                if(cnt >= t.length()) {
                    while(!map.containsKey(s.charAt(ptr1)) || map.get(s.charAt(ptr1)) < 0) {
                        if(map.containsKey(s.charAt(ptr1)) && map.get(s.charAt(ptr1)) < 0) {
                            map.put(s.charAt(ptr1), map.get(s.charAt(ptr1)) + 1);
                            cnt--;
                        }
                        ptr1++;
                    }
                    if(cnt == t.length() && map.get(s.charAt(ptr1)) == 0) {
                        if(res.isEmpty() || ptr2 - ptr1 + 1 < res.length()) res = s.substring(ptr1, ptr2 + 1);
                    }
                }
                ptr2++;
            }
        }
        return res;
    }
    
    /*
    two pointers and a cnt, cnt only increase when map.value . 0
    first pointer start to move when cnt >= t.length
    only move when the cnt in the arr > 1, then, decrease the arr value and cnt --;
    update the substring when cnt == t.length
    use a map to check if its in t or not.
    
    */
    public String minWindowCorrect(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        saveT(map, t);
        String res = "";
        int ptr1 = 0, ptr2 = 0, cnt = 0;
        while(ptr2 < s.length()) {
            char cha = s.charAt(ptr2);
            if(!map.containsKey(cha)) ptr2++;
            else {
                map.put(cha, map.get(cha) - 1);
                if(map.get(cha) >= 0) cnt++;
                if(cnt == t.length()) {
                    while(!map.containsKey(s.charAt(ptr1)) || map.get(s.charAt(ptr1)) < 0) {
                        if(map.containsKey(s.charAt(ptr1)) && map.get(s.charAt(ptr1)) < 0) {
                            map.put(s.charAt(ptr1), map.get(s.charAt(ptr1)) + 1);
                        }
                        ptr1++;
                    }
                    if(cnt == t.length() && map.get(s.charAt(ptr1)) == 0) {
                        if(res.isEmpty() || ptr2 - ptr1 + 1 < res.length()) res = s.substring(ptr1, ptr2 + 1);
                    }
                }
                ptr2++;
            }
        }
        return res;
    }
    
    private void saveT(Map<Character, Integer> map, String s) {
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
    }
}
