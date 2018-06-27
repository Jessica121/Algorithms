import java.util.HashMap;
import java.util.Map;

public class InterleaveString {
    /*
    s1. 0 - i: interleaves with s3. 0 - (i + j)
    s2. 0 - j:
    
    &&
    
    s1. i
    s2. j: interleaves with s3. (i + j) true.
    */
    public boolean isInterleave(String s1, String s2, String s3) {
        Map<String, Boolean> map = new HashMap<>();
        return isInterleave(s1, s2, s3, map);
    }
    
    private boolean isInterleave(String s1, String s2, String s3, Map<String, Boolean> map) {
        if((s1 + s2).equals(s3)) return true;
        String key = s1 + s2;
        if(map.containsKey(key)) return map.get(key);
        for(int i = 0; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {
                if(i == 0 && j == 0 || (i == s1.length() && j == s2.length())) continue;
                if(isInterleave(s1.substring(0, i), s2.substring(0, j), s3.substring(0, i + j)) &&
                   isInterleave(s1.substring(i), s2.substring(j), s3.substring(i + j))) {
                    map.put(key, true);
                    return true;
                }
            }
        }
        map.put(key, false);
        return false;
    }
    
    /*
    start from the back, i = s1.length(), j = s2.length(), k is for s3, which is decided by i + j.
    if(s1(i) == s3(k)) dp[i][j] = dp[i + 1][j]
    if(s2(j) == s3(k)) dp[i][j] = dp[i][j + 1]
    if neigther, dp[i][j] = false
    return dp[0][0] 

    */
    public boolean isInterleaveDP(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for(int i = s1.length(); i >= 0; i--) {
            for(int j = s2.length(); j >= 0; j--) {
                if(i == s1.length() && j == s2.length()) dp[s1.length()][s2.length()] = true;
                if(i + j >= s3.length()) continue;
                // the result wants to or with two conditions, one cannot override each other, use combined or.
                dp[i][j] = i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j] 
                        || (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}
