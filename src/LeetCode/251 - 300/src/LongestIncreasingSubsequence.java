
public class LongestIncreasingSubsequence {
    /*
    keep a DP array to count the max length of array till the index. 
    which is done by comparing each element before the current one. if it is smaller than the current one, check the dp array for the length it has. 
    keep track the max length possible.
    untill the index right before the current.
    then fill the DP array with the max length.
    after filling the DP, update the global max if necessary.
    keep two loops. 
    
    corner case: empty array
    nums: [10,9,2,5,3,7,101,18]
    dp:   [1, 1,1,2,2,3,4,4]
    
    */
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int localMax = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) localMax = Math.max(localMax, dp[j]);
            }
            dp[i] = localMax + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
