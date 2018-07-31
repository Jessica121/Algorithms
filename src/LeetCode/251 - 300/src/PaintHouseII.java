
public class PaintHouseII {
    /*
    each element in each row needs to check next dp row the smallest and update itself by adding it with itself. 
    if smallest is in the same index as the current one, take the second smallest. else go with the first smallest. 
    we dont care about thrid, fourth, etc, becuz they are not going to be used.
    start from the last row, track the indexes of the smallest one and second smallest one.
    and move up the row, if i == firstIndex, += dp[secondIndex][col], else add firstIndex.
    along the way, we update the current row's first and second index. but cannot do it on the original indexes. temp. *this is good* 
    out of the for loop, reassign temp to indexes.
    then return the smallest in the first row.
    
    corner case: empty array,
    overflow? 
    out of bounds.
    
    if want to keep first two biggest or smallest, when override the first one, need to override the second with the original first first.
   
    */
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        int firstIndex = -1, secondindex = -1, tempFirst = -1, tempSecond = -1;
        for(int i = costs.length - 1; i >= 0; i--) {
            for(int j = costs[0].length - 1; j >= 0; j--) {
                if(i < costs.length - 1) {
                    if(j == firstIndex) costs[i][j] += costs[i + 1][secondindex];
                    else costs[i][j] += costs[i + 1][firstIndex];
                }
                // when it is the first one check.
                if(tempFirst == -1 || costs[i][j] < costs[i][tempFirst]) {
                    // when overwrite the first one, need to overwrite the second one as well.
                    tempSecond = tempFirst;
                    tempFirst = j;
                } else if(tempSecond == -1 || costs[i][j] < costs[i][tempSecond]) tempSecond = j;
            }
            firstIndex = tempFirst;
            secondindex = tempSecond;
            // reset the temp first and second as well.
            tempFirst = tempSecond = -1;
        }
        return costs[0][firstIndex];
    }
}
