import java.util.*;

public class MajorityElement {
    /*
    majority element is the element that, when sorted, appered at the center (mid)
    
    */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length - 1) / 2];
    }
    
    /*
    number of majority element >= half length of the array
    if majority element is 1, then others -1, then majority will still be >= 1.
    so have a counter, is it is zero, set majority element the current element, 
    then if element == majority, increase the counter.
    else decrease.
    if cnt == 0, candidate will be set in the next round.
    then return the majority.
    
    to prove it: imagine that majority all at the end: it works.
    every majority with non-majority: 5 1 5 2 5 3 5 4 5 => 5 is the majority.
    */
    public int majorityElementBestAns(int[] nums) {
        int cnt = 0, majo = -1;
        for(int num : nums) {
            if(cnt == 0) majo = num;
            if(majo == num) cnt++;
            else cnt--;
        }
        return majo;
    }
}
