import java.util.*;
public class Combination {
    /*
    2 ^ k combs possible
    n = 4, k = 2
    1001, 1010, 1100, 0110, 0101, 0011 => overkill, not suitable for large n and k.
    use a set to track the selected numers, went from start, add only if its not in the set.
    add to the set, back track, remove, next.
    // could also, everytime, select one, swap with start, next we know when to start, dont need to check from the head again.
    dont need to swap, as if no dup, start from the start.
    dont need a set either. 
    
    */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        comb(1, n, k, temp, res);
        return res;
    }
    
    private void comb(int start, int n, int k, List<Integer> temp, List<List<Integer>> res) {
        if(temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = start; i <= n; i++) {
            temp.add(i);
            // next start is i + 1, not start + 1.
            comb(i + 1, n, k, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
