
public class NumberOfOneBits {
    /*
    >>> shift right of the n, check & 1 != 0. increase the cnt.
    
    */
    public int hammingWeight(int n) {
        int cnt = 0;
        for(int i = 0; i < 32; i++) {
            if(((n >>> i) & 1) != 0) cnt++;
        }
        return cnt;
    }

    public int hammingWeightLessShifting(int n) {
        int cnt = 0;
        for(int i = 0; i < 32; i++) {
            if((n & 1) != 0) cnt++;
            n >>>= 1;
        }
        return cnt;
    }
}
