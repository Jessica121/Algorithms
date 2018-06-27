
public class RemoveDupFromSortedArrII {
    /*
    have a cnter for each digit. if it == prev, check cnt == 1 ok, increase, else advance the interating pointer.
    goes until the digit not equal to prev. set prev, reset cnt = 0.
    return the second pointer. which tracks everything legal.
    
    */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int ptr1 = 0, ptr2 = 0, cnt = 0, prev = nums[0];
        while(ptr1 < nums.length) {
            if(nums[ptr1] == prev) {
                if(cnt < 2) {
                    cnt++;
                    // at first check this too.
                    nums[ptr2++] = nums[ptr1];
                }
            } else {
                prev = nums[ptr1];
                cnt = 1;
                nums[ptr2++] = nums[ptr1];
            }
            ptr1++;
        }
        return ptr2;
    }
}
