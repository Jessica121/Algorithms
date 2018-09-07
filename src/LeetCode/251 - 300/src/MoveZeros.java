
public class MoveZeros {
    /*
    two pointers, first track the next non zero element and swap with <= current index the position it belongs to.
    which it is tracked by the second pointer, second pointer goes one by one, and the first skip the 0s and stop at non 0
    have them points to first position first, while ptr1 is inbound and is 0 go to next index, ptr2 does not change.
    swap when ptr1 is non zero and increase both pointer.
    until ptr1 goes out of bound.
    then replace ptr2 index with 0s.
    
    */
    
    // [0,1,0,3,12]
    public void moveZeroes(int[] nums) {
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < nums.length) {
            while(ptr1 < nums.length && nums[ptr1] == 0) ptr1++;
            if(ptr1 < nums.length) swap(nums, ptr1++, ptr2++);
        }
        while(ptr2 < nums.length) nums[ptr2++] = 0;
    }
    
    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
