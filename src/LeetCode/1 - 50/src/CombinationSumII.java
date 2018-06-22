import java.util.*;
public class CombinationSumII {
    /*
    if it has dup, then sort it first, if equal prev & prev already in there, use, else skip.
    use a set to check the index
    still need a temp array to keep the elements in there. also need a set to check the index chosen
    
    */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        comb(candidates, 0, temp, res, set, target);
        return res;
    }
    
    private void comb(int[] arr, int start, List<Integer> temp, List<List<Integer>> res, Set<Integer> set, int target) {
        if(start == arr.length || target <= 0) {
            if(target == 0) res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = start; i < arr.length; i++) {
            if(i > start && arr[i] == arr[i - 1] && !set.contains(i - 1)) continue;
            set.add(i);
            temp.add(arr[i]);
            comb(arr, i + 1, temp, res, set, target - arr[i]);
            set.remove(i);
            temp.remove(temp.size() - 1);
        }
    }
    
    /*
    if it has dup, then sort it first, if equal prev & prev already in there, use, else skip.
    use a set to check the index
    still need a temp array to keep the elements in there. also need a set to check the index chosen
    
    
    optimize: actually, set is not needed.
    * if i > start and arr[i] == arr[i - 1], i - 1 must be selected, so at this point never selet later ones.
    as backtrack will remove the first index of the dup ones, it will never occur in set at the later ones have the same value.
    after the start index.
    */
    public List<List<Integer>> combinationSum2Optimized(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        comb(candidates, 0, temp, res, target);
        return res;
    }
    
    private void comb(int[] arr, int start, List<Integer> temp, List<List<Integer>> res, int target) {
        if(start == arr.length || target <= 0) {
            if(target == 0) res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = start; i < arr.length; i++) {
            if(i > start && arr[i] == arr[i - 1] ) continue;
            temp.add(arr[i]);
            comb(arr, i + 1, temp, res, target - arr[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
