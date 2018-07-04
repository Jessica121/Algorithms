
public class RotateArray {
    /*
    reverse the whole thing, then reverse 0 ~ k - 1, k ~ len.
    similar to reverse words in a string.
    
    */
    public void rotate(int[] nums, int k) {
        if(k <= 0) return;
        // mind k might larger than the array length, so take the mod first.
        k = k % nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }
    
    private void swap(int[] nums, int start, int end) {
        while(start < end) {
            int t = nums[start];
            nums[start++] = nums[end];
            nums[end--] = t;
        }
    }
}
