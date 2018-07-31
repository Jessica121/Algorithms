import java.util.*;
public class FactorialCombination {
    /*
    use a boolean flag to indicate whether it is original or not. if its not, add it to the temp, add temp to res, unadd it.
    if n == 1, add temp to res. 
    then check 2 to sqrt n, add to temp if temp is empty or last one is less than i.
    backtrack n / i
    
    */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        getFactors(n, temp, res, true);
        return res;
    }
    
    private void getFactors(int n, List<Integer> temp, List<List<Integer>> res, boolean isOri) {
        if(n == 1 && !isOri) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(!isOri) {
            temp.add(n);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
        }
        
        for(int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(n % i == 0 && (temp.size() == 0 || temp.get(temp.size() - 1) <= i)) {
                temp.add(i);
                getFactors(n / i, temp, res, false);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    /*
    you know a really smart way to check previous larger ? put i as the start of next iteration.
    however this might be slow as i = start .. n.
    so 12 = 2, 2, 3
            2, 3, 3 (X)
            2, 6
            3, 2 (X)
            3, 4
            4, 4 (X)
            6, 6 (X)
            12
    add temp to res only when its size > 1.
    */
    public List<List<Integer>> getFactorsSmarterButSlower(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        getFact(n, temp, res, 2);
        return res;
    }
    
    private void getFact(int n, List<Integer> temp, List<List<Integer>> res, int start) {
        if(n <= 1) {
            if(temp.size() > 1) res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i <= n; i++) {
            if(n % i == 0) {
                temp.add(i);
                getFact(n / i, temp, res, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
