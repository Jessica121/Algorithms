
public class SearchInRotatedSortedArrII {
    /*
    the only difference is when mid == start == end, need to search both sides
    if s > e return false
    if s == e return value == target
    
    
    */
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }
    
    private boolean search(int[] nums, int start, int end, int target) {
        if(start > end) return false;
        if(start == end) return nums[start] == target;
        int mid = start + (end - start) / 2;
        if(nums[mid] == target) return true;
        else if(nums[mid] == nums[end] && nums[mid] == nums[start]) 
            return search(nums, start + 1, mid - 1, target) || search(nums, mid + 1, end - 1, target);
        else if(nums[mid] <= nums[end]) {
        	// target could equal to end or start.
            if(target <= nums[end] && target > nums[mid]) return search(nums, mid + 1, end, target);
            else return search(nums, start, mid - 1, target);
        } else {
            if(target < nums[mid] && target >= nums[start]) return search(nums, start, mid - 1, target);
            else return search(nums, mid + 1, end, target);
        }
    }
}
