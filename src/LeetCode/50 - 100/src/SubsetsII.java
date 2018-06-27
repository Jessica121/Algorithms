import java.util.*;
public class SubsetsII {
    /*
    sort the array, not add the dup one if its not at the start index. (prev == cur && index != start)
    add the tep to result without condition checks
    */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        subset(0, nums, temp, res);
        return res;
    }
    
    private void subset(int index, int[] nums, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++) {
            if(i != index && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            subset(i + 1, nums, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
