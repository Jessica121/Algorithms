
public class MaxSubarray {
    /*
    prev + self > self ? add to prev, else self start.
    asthe subarray may start at any index, and must be continuous, use a max to track whenever made a step. whether add to prev or start a new.
    
    */
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, prev = 0;
        for(int i = 0; i < nums.length; i++) {
            if(prev + nums[i] >= nums[i]) prev += nums[i];
            else prev = nums[i];
            if(prev > res) res = prev;
        }
        return res;
    }
}
