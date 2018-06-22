
public class SearchForARange {
    /*
    Search for a range that, if mid equal the target, continue to search left and right, untill, the index is either at the start or end of the bound or its prev or next is not itself. then return the index.
    helper funciton return the int - index
    for each mid == target, check if itself is the begin or end of the range, if it is, return itself.
    problem is recursion return what? or iterative function how to perform left and right search at the same time.
    return subarray's range.
    */
    public int[] searchRange(int[] nums, int target) {
        return BS(nums, 0, nums.length - 1, target);
    }
    
    private int[] BS(int[] nums, int start, int end, int target) {
        if(start > end) return new int[] {-1, -1};
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int mid = start + (end - start) / 2;
        if(target < nums[mid]) return BS(nums, start, mid - 1, target);
        else if(target > nums[mid]) return BS(nums, mid + 1, end, target);
        else {
            int[] left = BS(nums, start, mid - 1, target), right = BS(nums, mid + 1, end, target);
            res[0] = left[1] == -1 ? mid : left[0];
            res[1] = right[0] == -1 ? mid : right[1];
        }
        return res;
    }
}
