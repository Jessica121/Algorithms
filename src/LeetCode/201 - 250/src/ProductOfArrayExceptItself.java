
public class ProductOfArrayExceptItself {
    /*
    create an array, first pass, first one is 1, second is first element * prev in res, next is i - 1 th element * prev in res arr
    second pass, start from the end of res array, flag = 1, flag ith in res array, flag *= i for the next use.
    
    corner case: empty array
    */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) res[i] = 1;
            else res[i] = res[i - 1] * nums[i - 1];
        }
        
        int flag = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] *= flag;
            flag *= nums[i];
        }
        return res;
    }
}
