import java.util.*;

public class SummaryRanges {
    /*
    overflow problem for sure, but since it is sorted... it will only happen when last one is INT_MAX, but will not be another ones.
    duplicates?? nope, good.
    check the start point. 
    if current is +1 than the prev, then update the end to cur, and continue. if not.
    start + -> + end put into res.
    then put cur as the start. end as null.
    out of the loop, if start and end both not null, add it. else only add the start.
    
    corner case: array is empty. 
    when the previous "range" is not a range.
    
    */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        String start = "", end = "";
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) start = "" + nums[i];
            else {
                if(nums[i] == nums[i - 1] + 1) end = "" + nums[i];
                else {
                	// **another corner case: is when previous itself is not a range.
                    res.add(end.isEmpty() ? start : new String(start + "->" + end));
                    start = "" + nums[i];
                    // reset the end to empty.
                    end = "";
                }
            }
        }
        // one corner case is for when the array is empty.
        if(!start.isEmpty()) {
            if(end.isEmpty()) res.add(start);
            else res.add(new String(start + "->" + end));
        }

        return res;
    }
}
