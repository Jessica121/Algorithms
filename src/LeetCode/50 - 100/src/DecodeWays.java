
public class DecodeWays {
    /*
    26 => 2, 6 || 26, rest
    dp[i] = dp[i + 1] + dp[i + 2], if (i, i + 1) <= 26 && i != 0
    else dp[i] = dp[i + 1]
    dp[length + 1]
    dp[last] = 1, second last = 1, start with i = s.length - 2
    
    */
    public int numDecodings(String s) {
        if(s.isEmpty()) return 0;
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        for(int i = s.length() - 2; i >= 0; i--) {
            if(s.charAt(i) == '0') dp[i] = 0;
            else if(Integer.valueOf(s.substring(i, i + 2)) <= 26) dp[i] = dp[i + 1] + dp[i + 2];
            else dp[i] = dp[i + 1];
        }
        return dp[0];
    }
}
