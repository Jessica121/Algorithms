import java.util.*;
public class CombinationSum {
    /*
    backtracking problem.
    temp list, target, res. 
    add when target == 0, if < 0 || i == length return
    for i = start till end, add temp, backtrack(i + 1, target - this val) 
    remove it.
    
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int[] arr, int start, int target, List<Integer> temp, List<List<Integer>> res) {
        // it could have result when the start equals the array length.
        if(start == arr.length || target <= 0) {
            if(target == 0) res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = start; i < arr.length; i++) {
            temp.add(arr[i]);
            backtrack(arr, i, target - arr[i], temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
