
public class FindMinInRotatedSortedArrayII {
    /*
    if mid == start && mid == end
    search both sides, start + 1 ~ mid - 1, mid + 1 ~ end - 1. return the min one.
    else if mid <= end, search left. start ~ mid
    mid <= start, search right.
    when start = end - 1. return the min one.
    */
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }
    
    private int find(int[] nums, int start, int end) {
        if(start >= end - 1) return Math.min(nums[start], nums[end]);
        int mid = start + (end - start) / 2;
        if(nums[mid] == nums[start] && nums[mid] == nums[end]) {
            int left = find(nums, start + 1, mid - 1), right = find(nums, mid + 1, end - 1);
            return Math.min(left, right);
        } else if(nums[mid] <= nums[end]) return find(nums, start, mid);
        else return find(nums, mid, end);
    }
}
