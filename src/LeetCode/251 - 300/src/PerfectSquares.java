import java.util.*;
public class PerfectSquares {
    /*
    start from sqrt(n), to 1, substract it and backtrack. when it is zero, return the count.
    pass te count in the function
    return the count as the result. for each feasible way, calculate the next and plus 1. take the min and return.
    need caching? yep. 13 -> 4 -> 9 -> 4 as well. 
    so need a map of integer of number of shortest ways, return when exist.
    else put.
    
    */
    public int numSquares(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return num(n, map);
    }
    
    private int num(int n, Map<Integer, Integer> map) {
        if(n == 0) return 0;
        if(map.containsKey(n)) return map.get(n);
        int res = Integer.MAX_VALUE;
        for(int j = (int) Math.sqrt(n); j >= 1; j--) {
            res = Math.min(res, num(n - j * j, map) + 1);
        }
        map.put(n, res);
        return res;
    }
}
