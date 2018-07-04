
public class FindPeakElement {
    /*
     * WHY this is binary search?
    binary search:
    if mid > left, mid > right return
    if start < mid < end search right.
    if mid < start and mid < end too. search right anyways. as it only requires to return one.
    if mid >= start and mid >= end, but smaller than neibor. search larger neibor. left first if both neibor equal as well.
    
    */
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1, mid = start + (end - start) / 2;
        while(start < end) {
            mid = start + (end - start) / 2;
            boolean greaterLeft = mid == 0 || nums[mid] > nums[mid - 1], greaterRight = mid == nums.length - 1 || nums[mid] > nums[mid + 1];
            if(greaterLeft && greaterRight) return mid;
            if(nums[mid] < nums[end]) start = mid + 1;
            else if(nums[mid] >= nums[end]) {
                if(greaterLeft) start = mid + 1;
                // mid could be less than both of the neibors as well, e.g. 1 2 1 2 1, so if not > than left, just search right.
                else end = mid - 1;
            }
        }
        return start;
    }
    
    /*
    since the target is to find one of them. get mid and compare to its right. this is because when the array only left with 2 elements, can check right not left.
    if mid > mid + 1, right half is cut off. right = mid.
    else mid < mid + 1, left and mid is cut off, left = mid + 1
    until start == end.
    
    */
    public int findPeakElementNeater(int[] nums) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
