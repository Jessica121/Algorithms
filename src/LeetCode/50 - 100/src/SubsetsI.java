import java.util.*;
public class SubsetsI {
    /*
    000 -> 111
    000 001 010 011 100 101 110 111
    wont work if the array exceeds 32 length.
    backtrack, i from start to end.
    add the temp without check.
    
    */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subset(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void subset(int[] nums, int index, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            subset(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
