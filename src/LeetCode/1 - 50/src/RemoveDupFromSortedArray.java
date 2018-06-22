
public class RemoveDupFromSortedArray {
    /*
    a pointer track distinct elements.
    another pointer track dup elements,
    if prev != null && equal to the prev, ptr2++, else ptr1++, reset the prev
    return the ptr1 + 1
    */
    public int removeDuplicates(int[] nums) {
        int ptr1 = 0, ptr2 = 0;
        Integer prev = null;
        while(ptr2 < nums.length) {
            if(prev == null || nums[ptr2] != prev) {
                prev = nums[ptr2];
                nums[ptr1++] = prev;
            } 
            ptr2++;
        }
        return ptr1;
    }
}
