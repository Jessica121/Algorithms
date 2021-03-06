import java.util.Arrays;
import java.util.Collections;

public class HIndex {
    /*
    sort the array once in increasing order, then the citation is len .. 1.
    we want to find value == len - index.
    iterate thru i = 0 .. len
    time nlogn.
    space 1.
    corner case: empty array. 
    overflow?
    invalid input? neg input?
    */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
        	// citation is at least, not strictly equal to.
        	// the value should >= to the length - i. since that is how much articles after it. and indicates the number of articles.
            if(citations[i] >= citations.length - i) return citations.length - i;
        }
        return 0;
    }
}
