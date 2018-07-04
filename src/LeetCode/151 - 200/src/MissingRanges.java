import java.util.*;
public class MissingRanges {
    /*
    generally, to find the missing range, it is left + 1 ~ right - 1.
    but for lower, left is lower, dont - 1, same as right, dont + 1.
    if left + 1 == right + 1, just put it. else put two with -> in between.
    
    */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        // i == nums.length included as when the array is empty.
        for(int i = 0; i <= nums.length; i++) {
            int left = i == 0 ? lower : nums[i - 1], right = i == nums.length ? upper : nums[i];
            // if left is already MAX and right is already MIN, continue.
            if(left == Integer.MAX_VALUE || right == Integer.MIN_VALUE) continue;
            // add here for overflow underflow problem.
            if(i != 0) left += 1;
            if(i != nums.length) right -= 1;
            if(left > right) continue;
            if(left == right) res.add(String.valueOf(left));
            else if(left < right) {
                String value = left + "->" + right;
                res.add(value);
            }
        }
        return res;
    }
    
    /*
    generally, to find the missing range, it is left + 1 ~ right - 1.
    but for lower, left is lower, dont - 1, same as right, dont + 1.
    if left + 1 == right + 1, just put it. else put two with -> in between.
    
    */
    public List<String> findMissingRangesWithLong(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++) {
            long left = i == 0 ? lower : (long) nums[i - 1] + 1, right = i == nums.length ? upper : (long) nums[i] - 1;
            if(left > right) continue;
            if(left == right) res.add(String.valueOf(left));
            else if(left < right) {
                String value = left + "->" + right;
                res.add(value);
            }
        }
        return res;
    }
}
