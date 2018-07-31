import java.util.Arrays;

public class ThreeSumSmaller {
    /*
    sort the array once, then take the first element, take its compliment, take from i + 1 and end.
//    de-duplicate first，by checking later one, if not out of bounds, == self for ptr1. ptr2 same. then check:
 * no need to de-duplicate here. as is to find the indexes.
    if it's less than compliment, and save to res ptr2 - ptr1; ptr1++
    else ptr2--
    n^2
    
    */
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        int ptr1 = 0, ptr2 = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int compli = target - nums[i];
            ptr1 = i + 1;
            ptr2 = nums.length - 1;
            while(ptr1 < ptr2) {
                if(ptr1 < ptr2 && nums[ptr1] + nums[ptr2] < compli) res += ptr2 - ptr1++;
                else if(ptr1 < ptr2 && nums[ptr1] + nums[ptr2] >= compli) ptr2--;
            }
        }
        return res;
    }
}
