
public class KthLargestInArray {
	/*
    find the index of len - k in sorted order.
    quick select, return the index of the pivot. arr[start] 
    if the index > target index, find start .. index - 1
    else index + 1.. end
    if equal, return this element.
    start == end return index,
    else return -1.
    pass up the index and return the element.
    
    quick select: start pointer <= pivot, igrnore, continue, else swap with end, end--;
    while(start <= end) swap pivot and end, return end.
    
    */
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int index = quickSelect(nums, 0, nums.length - 1, target);
        return nums[index];
    }
    
    private int quickSelect(int[] nums, int start, int end, int target) {
        if(start > end) return -1;
        if(start == end) return start;
        int pivot = nums[start], ptr1 = start + 1, ptr2 = end;
        while(ptr1 <= ptr2) {
            if(nums[ptr1] <= pivot) ptr1++;
            else {
                swap(nums, ptr1, ptr2);
                ptr2--;
            }
        }
        swap(nums, start, ptr2);
        if(ptr2 == target) return ptr2;
        else if(ptr2 > target) return quickSelect(nums, start, ptr2 - 1, target);
        else return quickSelect(nums, ptr2 + 1, end, target); 
    }
    
    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
