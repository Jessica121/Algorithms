
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
}
