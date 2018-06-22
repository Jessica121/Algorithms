
public class DivideTwoIntegers {
    /*
    itertively do:
    if one is neg, toAdd = -toAdd, put the neg into positive => one thing to note is overflow, when put MIN to positive, will be 0.
    so need to translate dvd, dvs, res into long.
    if both neg, should working
    while(dvd >= dvs)
        if dvd >= dvs, res += toAdd
        dvd -= dvs
        toAdd <<= 1, dvs <<= 1, 
    dvs = orignalDvs
    toAdd == original toAdd
    return res;
    
    */
    public int divide(int dividend, int divisor) {
        if((dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        long res = 0, dvd = dividend, dvs = divisor;
        int toAdd = 1;
        boolean oneNeg = (dividend < 0) ^ (divisor < 0);
        if(oneNeg) toAdd = -toAdd;
        if(divisor < 0) dvs = -dvs;
        if(dividend < 0) dvd = -dvd;
        int constAdd = toAdd;
        long constDvs = dvs;
        while(dvd >= dvs) {
            while(dvd >= dvs) {
                dvd -= dvs;
                res += toAdd;
                toAdd <<= 1;
                dvs <<= 1;
            }
            dvs = constDvs;
            toAdd = constAdd;
        }
        return (int) res;
    }
}
