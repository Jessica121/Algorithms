
public class SingleNumberIII {
    /*
    i dont think i will come up with this on my own, but i learnt divide the group by the set bit.
    
    so XOR with all the num, get the XOR of the two number diff.
    // then take the last set bit .diff &= 1. this wont work cuz we want a bit that is 1. and we dont know where it is.
     * a magic way to do this is to use diff &= ~ (diff - 1) i dont know how it came up with it.
     * the key to this problem is to separate two group by a set bit of 1. then two single numbers are not together.
    group the array again with the random set bit.
    XOR with [0] if num & diff == 1, [1] if == 0. does not matter who place to where actually.
    
    */
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int diff = getXOR(nums);
        diff &= ~(diff - 1);
        for(int num : nums) {
            if((num & diff) != 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
    
    private int getXOR(int[] nums) {
        int res = 0;
        for(int num : nums) res ^= num;
        return res;
    }
}
