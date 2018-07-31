import java.util.Arrays;

public class PaintHouse {
    /*
    have one dp[3], another int[3] to store the temp.
    for each element, check with other cols in dp, get the min and store there.
    replace the dp.
    untill the last is finished, get one pass in dp to get the min.

    */
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;
        int[] dp = new int[3];
        for(int[] cost : costs) {
            int[] temp = new int[3];
            Arrays.fill(temp, Integer.MAX_VALUE);
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(i != j) temp[i] = Math.min(temp[i], cost[i] + dp[j]);
                }
            }
            dp = temp;
        }
        return getMin(dp);
    }
    
    /*
     * can compare directly the other two by add 1 an 2 and mod by 3. wrap around the array.
     * */
    public int minCostBetter(int[][] costs) {
        if(costs.length == 0) return 0;
        int[] dp = new int[3];
        for(int[] cost : costs) {
            int[] temp = new int[3];
            for(int i = 0; i < 3; i++) 
                temp[i] = cost[i] + Math.min(dp[(i + 1) % 3], dp[(i + 2) % 3]);
            dp = temp;
        }
        return getMin(dp);
    }
    
    private int getMin(int[] dp) {
        int res = Integer.MAX_VALUE;
        for(int d : dp) res = Math.min(d, res);
        return res;
    }
}
