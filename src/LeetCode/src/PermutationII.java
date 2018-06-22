import java.util.*;
public class PermutationII {
    /*
    first sort the array first, dup happens when 1 1 1 the first one is chosen, and second and third one if chosen respectly.
    if cur is not at the start, prev == cur, and the prev is there, add it. 
    swap with start, recurse start + 1.
    add when temp size is nums.length
    why this wont work is swapping may rearrange things again.
    
    */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        permute(nums, temp, res, new HashSet<>());
        return res;
    }
    
    private void permute(int[] nums, List<Integer> temp, List<List<Integer>> res, Set<Integer> set) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i - 1] == nums[i] && !set.contains(i - 1) || set.contains(i)) continue;
            set.add(i);
            temp.add(nums[i]);
            permute(nums, temp, res, set);
            temp.remove(temp.size() - 1);
            set.remove(i);
        }
    }
}
