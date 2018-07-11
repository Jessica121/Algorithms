import java.util.TreeSet;

public class ContainsDuplicateIII {
    /*
     * BF
    start with index i = 0 .. len.
    for each index, run a loop of j = i .. i + k (take the shorter one either with this or the end of the array)
    check the diff between them is <= t.
    check to the end, return false outside.
    
    corner case: nums.length < k should be fine actually.
    k == 0 is a corner case
    overflow why is everywhere god damn it. remember it. good.
 
    */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j <= Math.min(i + k, nums.length - 1); j++) {
                if(Math.abs((long) nums[j] - (long) nums[i]) <= (long) t) return true;
            }
        }
        return false;
    }
    
    /*
    
    Search within a dynamic range / maintaining the range in which it searches.
    the idea is maintaining a binary search tree, and maintain it in the size that most recent < k elements. so currecnt element will make sure the range is within k, and can safely search for cur +/- t value.
    why the range is only range from the left side? cuz for the right half, it will be taken care of in later element.
    
    basically just keep the number of elements in that range, and search for targeted elements (logn for each search and remove)
    
    search in the tree set for lower cur + t and higher cur - t.
    if one of them not null, return true.
    else put it into the set, remove the oldest element: nums[i - k]
    
    out of the loop return false, for each element not found one.
    
    same as liner search, just binary search tree will be better, why not array ? have to resbuild the tree all the time.
    */
    public boolean containsNearbyAlmostDuplicateBST(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
        	// higher and lower and strictly saying. so loss the bound a little bit.[p
            Long upper = set.lower((long) nums[i] + t + 1), lower = set.higher((long) nums[i] - t - 1);
            // could be cur is 5, set has 1, find lower (5 + 3 + 1) == 1 -> exist but shoud greater than 5 also.
            if(upper != null && upper >= nums[i] || (lower != null && lower <= nums[i])) return true;
            set.add((long) nums[i]);
            if(set.size() > k) set.remove((long) nums[i - k]);
        }
        return false;
    }
}
