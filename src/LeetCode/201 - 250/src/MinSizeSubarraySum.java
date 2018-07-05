
public class MinSizeSubarraySum {
    /*
    obviously two pointers?
    advance the second pointer, when the sum equal target, update the length.
    if bigger, shrink the left. untill the sum is smaller or equal than target.
    then keep going, adding the number when first ptr goes, substracting second.
    shrinking the ptr1 is independent with checking the sum is equal to target.
    
    corner case: empty input array.
    
    */
    public int minSubArrayLen(int s, int[] nums) {
        int ptr1 = 0, ptr2 = 0, sum = 0, res = -1;
        while(ptr2 < nums.length) {
            sum += nums[ptr2++];
            while(sum >= s && ptr1 <= ptr2) {
            	// the condition requires the sum >= than target. so update inside here..
                if(sum >= s) res = res == -1 ? ptr2 - ptr1 : Math.min(res, (ptr2 - ptr1));
                sum -= nums[ptr1++];
            }
        }
        return res == -1 ? 0 : res;
    }
}
