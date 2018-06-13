
public class MaxSubarray {
    /*
    prev = 0, if prev + cur >= cur, prev = prev + cur, 
    else update the res, end = cur index - 1; prev = cur, cur start = cur index.
    
    */
    public int maxSubArray(int[] nums) {
        Integer prev = null, start = -1, curStart = -1, end = -1, max = Integer.MIN_VALUE;
        // [-2,1,-3,4,-1,2,1,-5,4]
        for(int i = 0; i < nums.length; i++) {
            if(prev != null && prev + nums[i] >= nums[i]) {
                prev = prev + nums[i];
            } else {
                prev = nums[i];
                curStart = i;
            }
            // since it is possible that the prev included res that are not optimal / optimal, update in every pass.
            if(prev > max) {
                max = prev;
                start = curStart;
                end = i;
            }
        }
        System.out.println("Max subarray ranges from: " + start + " to " + end);
        return max;
    }
}
