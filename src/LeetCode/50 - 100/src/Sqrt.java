
public class Sqrt {
    /*
    keep * 2, find a point where the x < 2^N and do binary search on it.
    start from its half, if half * half > self, take take half's half, if bigger take its middle.
    binary search on 0 and half.
    return end.
    integer problems overflow - balance the things out in both sides.
    
    */
    public int mySqrt(int x) {
        if(x == 1) return 1;
        // divide by two need to consider special cases when x is <= 2.
        int e = x / 2, s = 0, mid = 0;
        while(s <= e) {
            mid = s + (e - s) / 2;
            if(mid == 0) return e;
            // no overflow balance two in two sides.
            if(mid == x / mid) return mid;
            else if(mid > x / mid) e = mid - 1;
            else s = mid + 1;
        }
        return e;
    }
}
