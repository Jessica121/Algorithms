
public class searchInsert {
    /*
    Basic Binary Seach: knows where to insert.
    if not found return start;
    if found return.

    */
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(target == nums[mid]) return mid;
            else if(target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}
