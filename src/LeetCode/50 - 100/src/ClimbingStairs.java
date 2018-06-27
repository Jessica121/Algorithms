
public class ClimbingStairs {
    /*
    DP problem: dp[i] = dp[i + 1] + dp[i + 2]
    return dp[0]
    
    */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for(int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + (i + 2 <= n ? dp[i + 2] : 0);
        }
        return dp[0];
    }
}
