
public class PowerOfTwo {
    /*
    one is power of two when n % 2 == 0 && isPowerOfTwo(n / 2)
    0 is false.
    1 is true.
    
    time will be log(MAX)
    corner case: n < 0 :]
    */
    public boolean isPowerOfTwo(int n) {
        if(n <= 0 || n == 1) return n <= 0 ? false : true;
        return n % 2 == 0 && isPowerOfTwo(n / 2);
    }
}
