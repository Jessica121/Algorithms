
public class HouseRobberII {
    /*
    for odd number, compare starting points from 0 ~ len - 1 and 1 ~ len. (excl.)
    for even, just like rob I.
    correction: actually even might have the same issue as well, so for both of them, ran twice.
    corner case: array is len of 0.
    
    */
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        else return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] nums, int start, int end) {
    	// mind if start > end, meaning array is 0. return 0.
        if(start > end) return 0;
        int[] dp = new int[end - start + 2];
        for(int i = start; i <= end; i++) {
            if(i == start) dp[i + 1 - start] = nums[i];
            else dp[i + 1 - start] = Math.max(dp[i - start], dp[i - 1 - start] + nums[i]);
        }
        return dp[dp.length - 1];
    }
}
