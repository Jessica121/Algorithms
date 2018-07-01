
public class SingleNumber {
    /*
    xor, each and everyone, the one is left is the result
    */
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) res ^= num;
        return res;
    }
}
