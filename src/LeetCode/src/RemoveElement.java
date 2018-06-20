
public class RemoveElement {
    /*
    two pointers, one is the pointer after removing, one check the array.
    if nums[ptr2] != target, nums[ptr1++] = nums[ptr2++]
    else ptr2++
    return ptr1
    */
    public int removeElement(int[] nums, int val) {
        int ptr = 0;
        for(int num : nums) {
            if(num != val) nums[ptr++] = num;
        }
        return ptr;
    }
}
