
public class BitwiseANDofNumbersRange {
    /*
    pos 0 : every 2 ^ 0 is a pair 0 or 1, pos 1: every 2 ^ 1 is a pair 0 or 1, pos 3: every 2 ^ 2 is a 0 or one.
    so calculate the number in the range: n - m + 1.
    if number > 2 ^ 0, must contain at least one 0 and hence is a 0.
    then compare to 2 ^ 1, if bigger must be 0.
    if smaller, then its tricky: check the first number and last number of that digit: if 1 zero one 0, then must 0. if equal should equal to that digit. 
    do this from 2 ^ 0 to 2 ^ 31.
    observing the fact that 0 and 1 are interchanging 
    
    */
    public int rangeBitwiseAnd(int m, int n) {
        int toComp = 1, res = 0, range = n - m + 1;
        for(int i = 0; i < 32; i++) {
            if(range <= toComp) {
                int lower = m & (1 << i), higher = n & (1 << i);
                if(((lower > 0 ? 0 : 1) ^ (higher > 0 ? 0 : 1)) == 0) {
                    if(lower != 0) res |= 1 << i;
                }
            }
            toComp *= 2;
        }
        return res;
    }
}
