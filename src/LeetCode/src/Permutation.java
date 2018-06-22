import java.util.*;
public class Permutation {
    /*
    use a set to track the index that added, always start from 0. add if not in set, recurse, remove. 
    till index == nums.length;
    add to the temp list.
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        permute(temp, res, new HashSet<>(), nums);
        return res;
    }
    
    private void permute(List<Integer> temp, List<List<Integer>> res, Set<Integer> set, int[] nums) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(i)) {
                set.add(i);
                temp.add(nums[i]);
                permute(temp, res, set, nums);
                temp.remove(temp.size() - 1);
                set.remove(i);
            }
        }
    }
    
    /*
    a smart way is to move everthing we selected before a index so next recursion will use the next index to it.
    it dont have to check from 0 everytime again
    so i start from start till the end of nums, swap with the start, and next recursion call is going to use start + 1 as the starting index.
    eveything will be in place in the array itself. => but still need temp array cuz its stupid pass by value
    back track to swap back
    */
    public List<List<Integer>> permuteSmart(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        permute(0, temp, res, nums);
        return res;
    }
    
    private void permute(int start, List<Integer> temp, List<List<Integer>> res, int[] nums) {
        if(start == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            swap(nums, i, start);
            permute(start + 1, temp, res, nums);
            swap(nums, i, start);
            temp.remove(temp.size() - 1);
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
