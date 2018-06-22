
public class SearchInRotatedArray {
    /*
    the mid point, check with the start, if start < mid, and val falls in range, return left. else right
                                         if mid < end,  and val falls in range, return right. else left
                                         if mid == target, return the value.
                                         log n still.
    
    */
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }
    
    private int search(int[] nums, int start, int end, int target) {
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] < nums[end]) {
        	// one thing is target could equal to end and start.
            if(target > nums[mid] && target <= nums[end]) return search(nums, mid + 1, end, target);
            else return search(nums, start, mid - 1, target);
        } else {
            if(target < nums[mid] && target >= nums[start]) return search(nums, start, mid - 1, target);
            else return search(nums, mid + 1, end, target);
        }
    }
}
