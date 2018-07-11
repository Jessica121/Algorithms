
public class KthLargestElememtInArray {
    /*
    1 2 3 4 5 6
    len - k is the index after sorted.
    so quick sort, return the index of the partial swapped array of the pivot: when the pivot == len - k, return
    if less, find right start is pivot + 1. also return the index of the swapped array.
    else end is pivot - 1.
    
    swapping algorithm: pivot the left most as the pivot, keep a pointer at the bigger end.
    if bigger than pivot, swap with bigger index--
    until the i exceeds the big, then swap the left with i.
    return i.
    
    corner case: k < 0, k > length, nums is empty
    array has the length of 1.
    
    */
    public int findKthLargest(int[] nums, int k) {
        if(k < 0 || k > nums.length) return -1;
        int index = nums.length - k;
        int start = 0, end = nums.length - 1;
        // while true here. as the index is adjusted regarding the result, it will reach a result.
        while(true) {
            int pivot = quickSelect(nums, start, end);
            if(pivot == index) return nums[pivot];
            else if(pivot > index) end = pivot - 1;
            else start = pivot + 1;
        }
    }
    
    private int quickSelect(int[] nums, int start, int end) {
    	// return the index.
        if(start == end) return start;
        int bigger = end, iter = start + 1, pivot = nums[start];
        while(iter <= bigger) {
            if(nums[iter] > pivot) swap(nums, iter, bigger--);
            else iter++;
        }
        swap(nums, start, bigger);
        return bigger;
    }
    
    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
