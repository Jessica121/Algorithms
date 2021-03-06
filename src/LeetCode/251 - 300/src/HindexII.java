
public class HindexII {
    /*
    binary search on the sorted array.
    take the middle, check value >= len - i : == return len - i, else update res = len - i, end = mid - 1
    if value < len - i, start = mid + 1;
    is it possible that does not exist ? => every value < len - i, neg, wont happen. if its 0, res = 0. does not have it.
    
    */
    public int hIndex(int[] citations) {
        int res = 0;
        int start = 0, end = citations.length - 1, mid = -1;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(citations[mid] == citations.length - mid) return citations.length - mid;
            else if(citations[mid] > citations.length - mid) {
                res = citations.length - mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return res;
    }
    
    /*
    since it is sorted, and could be done in binary search as well then.
    take the middle, if val >= length - i, save the length - i as the candidate.
    then go left, end = mid - 1. else start = mid + 1.
    else if val < length - i, start = mid + 1
    until start > end.
    
    */
    public int hIndex2(int[] citations) {
        int candidate = 0, start = 0, end = citations.length - 1, mid = -1;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(citations[mid] < citations.length - mid) start = mid + 1;
            else {
                candidate = citations.length - mid;
                end = mid - 1;
            }
        }
        return candidate;
    }
}
