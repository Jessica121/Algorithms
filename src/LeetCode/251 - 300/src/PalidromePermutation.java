import java.util.*;
public class PalidromePermutation {
    /*
    the idea is to have <= 1 char that has odd count.
    use an array of 26, assuming only a - z are involved.
    count the number of each character. if after it is odd, cnt++, else cnt--.
    return count <= 1;
    
    if UNICODE use a map.
    
    */
    public boolean canPermutePalindrome(String s) {
        int cnt = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            map.put(cha, map.getOrDefault(cha, 0) + 1); 
            if(map.get(cha) % 2 != 0) cnt++;
            else cnt--;
        }
        return cnt <= 1;
    }
}
