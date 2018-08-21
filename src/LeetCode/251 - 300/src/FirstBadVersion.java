
public class FirstBadVersion {
    /*
    GGGBBBB
    1234567
    take the middle, if its bad, move end to mid - 1, if its good, move start to mid + 1, until ! start <= end, return start
    corner case is there is no bad version, return result will be n + 1. which make sense / could be treated as the sign of no bad versions. if all bad, end will be -1 and start will be 0. BBB should be correct.
    */
    public int firstBadVersion(int n) {
        int start = 1, end = n, mid = -1;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(isBadVersion(mid)) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
}
