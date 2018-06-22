
public class NextPermutation {
    /*
    This is similar to the find the next greater and smaller one with the same number of bit in bit manupulation
    after find the correct change, need to arrang the right half into correct order as well.
    
    still, find the first one in dp that not equal to itself and find the one just bigger than that. swap and sort the index + 1 till end.
    
    find the one just bigger than that, could be find later values in dp and stop when the rep value smaller or out of bounds, or could be start from the last of the array and stop till the value is larger than that. this wont go over the current value as later ones must have something larger than that.
    
    */
    public void nextPermutation(int[] nums) {
        int[] dp = new int[nums.length];
        buildDp(dp, nums);
        int index = -1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(dp[i] != i) {
                index = i;
                break;
            }
        }
        if(index != -1) {
            for(int i = nums.length - 1; i > index; i--) {
                if(nums[i] > nums[index]) {
                    swap(nums, i, index);
                    break;
                }
            }
        }
        swapAll(index + 1, nums);
    }
    
    private void swapAll(int start, int[] nums) {
        int end = nums.length - 1;
        while(start < end) {
            swap(nums, start++, end--);
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    private void buildDp(int[] dp, int[] nums) {
        dp[dp.length - 1] = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            dp[i] = nums[i] >= nums[dp[i + 1]] ? i : i + 1;
        }
    }
    
    /* Find the index by finding index - 1 < index*/
    public void nextPermutationNoDp(int[] nums) {
        // mark index as -1 because 0 could be the index or 0 is when it is already the largest.
        int index = -1;
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
         if(index != -1) {
            for(int i = nums.length - 1; i > index; i--) {
                if(nums[i] > nums[index]) {
                    swap(nums, i, index);
                    break;
                }
            }
        }
        swapAll(index + 1, nums);
    }
}
