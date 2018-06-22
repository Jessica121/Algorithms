import java.util.*;
public class LongestValidParent {
    /*
    this is for each index, start search substring.
    if is fully closed form, check next.
    the return res must be starting from current index, valid. not hopping over characters.
    The need to understand what the problem wants is important.
    The most intuitive way is to for all the index, find the max substring. use a map to cache max for each index.
    This leads to a DP approach that comes later
    */
    public int longestValidParentheses(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            max = Math.max(max, check(s, i, map));
        }
        return max;
    }
    
    private int check(String s, int index, Map<Integer, Integer> map) {
        if(map.containsKey(index)) return map.get(index);
        if(index == s.length()) return 0;
        int left = 0, right = 0;
        int max = 0;
        for(int j = index; j < s.length(); j++) {
            if(s.charAt(j) == '(') left++;
            else right++;
            if(right > left) break;
            if(left == right) {
                int next = check(s, j + 1, map);
                if(right + left + next > max) max = right + left + next;
            }
        }
        map.put(index, max);
        return max;
    }
    
    /*
    The DP approach will be, for each index, check the substring, if valid, check the next of later one staring right after the end. this requires knowing the later ones first, so start from end work towards head.
    i = len - 1 .. 0, j = i till end.
    if start from current index, no matching found, return 0. 
    for each result calculated, update the max along the way.
    */
    public int longestValidParenthesesDP(String s) {
        int max = 0, left = 0, right = 0;
        int[] dp = new int[s.length() + 1];
        for(int i = s.length() - 1; i >= 0; i--) {
            int localMax = 0;
            for(int j = i; j < s.length(); j++) {
                if(s.charAt(j) == '(') left++;
                else right++;
                if(right > left) break;
                if(left == right) {
                    if(left + right + dp[j + 1] > localMax) localMax = left + right + dp[j + 1];
                }
            }
            dp[i] = localMax;
            max = Math.max(max, dp[i]);
            left = 0;
            right = 0;
        }
        return max;
    }
}
