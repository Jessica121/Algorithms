import java.util.*;
public class CombinationSumIII {
    /*
    the meaning of unique set of numbers is, only move forward without going back. as back are handled back.
    int i = 0, if i == k, and the sum == n, add the temp to the result.
    then backtrack.
    if sum > n, return, if sum == n but i < k, return.
    i starts for each element in the 1 to 9.
    
    corner case: n <= 0, k <= 0
    
    */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        comb(1, 0, 0, k, n, temp, res);
        return res;
    }
    
    private void comb(int start, int index, int sum, int k, int n, List<Integer> temp, List<List<Integer>> res) {
        if(index == k && sum == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(sum > n || (sum == n && index < k)) return;
        
        for(int i = start; i < 10; i++) {
            temp.add(i);
            comb(i + 1, index + 1, sum + i, k, n, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
