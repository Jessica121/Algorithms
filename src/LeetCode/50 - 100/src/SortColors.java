
public class SortColors {
    /*
    three ptrs, one 0, one end, one goes.
    if 1, advance first pointer, if 2, swap with end--, ptr1 not changed.
    if 0, swap with first pointer++
    until iterating pointer exceeds the end.
    make sure the codes aligns with the thoughts. for example, after swapping with the first pointer, it goes 
    */
    public void sortColors(int[] nums) {
        int ptr1 = 0, ptr2 = nums.length - 1, i = 0;
        while(i <= ptr2) {
            if(nums[i] == 0) {
                swap(nums, i, ptr1++);
                // is either zero or 1, need to go anyways
                i++;
            } else if(nums[i] == 2) swap(nums, i, ptr2--);
            else i++;
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
