
public class ReverseBits {
    /*
    take the bit at index i and 31 - i. set it. until start meet the end.
    if call multiple time, cache the result? what else could you do?
    
    */
    public static int reverseBits(int n) {
        int start = 0, end = 31;
        while(start < end) {
            int left = n & (1 << start), right = n & (1 << end);
            // since it is unsigned, after get the bit, it might be negative. so safe bet is check != 0.
            if(((left != 0 ? 0 : 1) ^ (right != 0 ? 0 : 1)) == 1) {
                n ^= 1 << start;
                n ^= 1 << end;
            }
            start++;
            end--;
        }
        return n;
    }
    
    public static void main(String[] args) {
    	reverseBits(2147483647);
    }
}
