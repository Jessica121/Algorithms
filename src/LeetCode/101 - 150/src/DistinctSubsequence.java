
public class DistinctSubsequence {
    /*
    the relation is: if the char equal in s and t, find in the same row: same end in t, but shorter in substring in s, how many, and previous row: within this length so far in s, how many previous char so i can concat to.
    two dimentional look up in dp, substring problem:
    2D dp, which involves char by char loop up in one string againest scanning look up in another.
    dp[s.length() + 1][t.length() + 1]
    dp[0] all 0, dp[x][0] = 1
    
    */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        initRow(dp);
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i][j - 1];
                // mind this is j - 1, because previous char may equal to the current one. so should be j - 1. not j
                if(t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] += dp[i - 1][j - 1]; 
            }
        }
        return dp[t.length()][s.length()];
    }
    
    private void initRow(int[][] dp) {
        for(int i = 0; i < dp[0].length; i++) dp[0][i] = 1;
    }
}
