
public class SingleNumberII {
    /*
    for 32 bits, each bit for each element, left shift by that bit and get the bit.
    track the number of 1s, cuz zero has no effect. += &1
    mod by 3, can get the special value.
    mod by k, apply to a more general situation.
    res this sum after mod by 3, set the bit, by |= sum << i
    10
    10
    10
    11
    --
    11
    
    */
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int num : nums) {
                sum += (num >> i) & 1;
            }
            res |= (sum % 3) << i;
        }
        return res;
    }
}
