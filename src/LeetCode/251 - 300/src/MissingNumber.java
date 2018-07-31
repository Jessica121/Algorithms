
public class MissingNumber {
    /*
    calculate the expected sum..
    expected sum: (1 + len) * len / 2
    
    */
    public int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        for(int num : nums) sum -= num;
        return sum;
    }
    
    /*
    check for i = 0 .. nums.length, XOR with the ones in the array. the one left is the missing one.
    
    */
    public int missingNumberXOR(int[] nums) {
        int all = XORAll(nums.length);
        for(int num : nums) all ^= num;
        return all;
    }
    
    private int XORAll(int len) {
        int res = 0;
        for(int i = 0; i <= len; i++) res ^= i;
        return res;
    }
    
    /*
    XOR with the index. 0 .. len - 1. so init it as len.
    the value is the missing one.
    
    */
    public int missingNumberBest(int[] nums) {
        int res = nums.length;
        for(int i = 0; i < nums.length; i++) {
            res ^= (i ^ nums[i]);
        }
        return res;
    }
}
