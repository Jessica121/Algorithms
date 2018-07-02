
public class MinInRotatedSortedArray {
    /*
    normally it would be the first element.
    however since it is rotated..... would be like a normal binary search.
    get the mid element, it should > s and < e
    if mid > end, search right. 
    if mid < start, search left.
    the problem is when to stop. if there is only one element left, start == end. compare left and right to return the min?
    or when search left or right, put itself into the range as well. when there left with 2 elemets, return the min.
    */
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start < end - 1) {
            mid = start + (end - start) / 2;
            if(nums[mid] < nums[end]) end = mid;
            else start = mid;
        }
        return Math.min(nums[start], nums[end]);
    }
}
