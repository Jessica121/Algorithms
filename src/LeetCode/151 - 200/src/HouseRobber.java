
public class HouseRobber {
    /*
    dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]), it wont go far as dp[i - 4], as adding dp[i - 2] will always be better.
    take dp length - 1 and dp length - 2
    
    */
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 3];
        for(int i = 0; i < nums.length; i++) {
            dp[i + 3] = Math.max(dp[i + 1], dp[i]) + nums[i];
        }
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
    
    /*
    of course this can be modified into constant space. but need to save two.
    prevprev, prev, max (these two.)
    prevprev = prev, prev = cur
    
    */
    public int robConstantSpace(int[] nums) {
        int ppp = 0, pp = 0, p = 0, cur = 0;
        for(int i = 0; i < nums.length; i++) {
            cur = Math.max(ppp, pp) + nums[i];
            ppp = pp;
            pp = p;
            p = cur;
        }
        return Math.max(p, pp);
    }
    
    /*
    dp[i] = rob, dont rob:
            rob: num + dp[i - 2]
            dont rob: dp[i - 1]
    return the last.
    */
    public int robLogicalDP(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length + 2];
        for(int i = 0; i < nums.length; i++) {
        	// mind not i <= 1 use it directly, compare previous starting from 1. so better have a dp with extra space with it.
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }
        return dp[dp.length - 1];
    }
}
