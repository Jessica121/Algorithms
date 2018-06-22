
public class JumpGameII {
    /*
    for each element, go from i to the value steps, get the min step and store.
    from back to front
    then return the dp[0]
    level min.
    for(int i = 1; i <= val; i++)
    index + i in dp + 1. 
    
    */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = nums.length - 2; i >= 0; i--) { // last one will always be zero. yay.
            if(nums[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= nums[i]; j++) {
                if(i + j < nums.length && dp[i + j] != Integer.MAX_VALUE) min = Math.min(min, dp[i + j] + 1);
            }
            dp[i] = min;
        }
        return dp[0];
    }
    
    /*
     * Greedy 
    First touch of the greedy algorithm:
    so one jump can cover a range that is defined by previous steps.
    when it moves within this range, it also defines the range for the next jump.
    when it reach the end of the range, jump increase, the start is the end and the new end is the max defined by this range.
    stop when it reaches the end of the array. even if the range is not done yet.
    the range from start is 0 and 0.
    next end is 0 also.
    run and i and a jump. when go to the next range, start will already be set.
    */
    public int jumpGreedy(int[] nums) {
        int jump = 0, end = 0, nextEnd = 0, i = 0;
        while(i < nums.length - 1) {
            nextEnd = Math.max(nextEnd, i + nums[i]);
            if(i == end) {
                jump++;
                end = nextEnd;
            }
            i++;
        }
        return jump;
    }
}
