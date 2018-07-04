
public class DungeonGame {
    /*
    take the path with min blood needed: 
    intersting fact: if the current >= 0, substract the min of the two neibor.
                            current < 0, take the max of (plus the min of neibor, neg self + 1).
    triple condition better wrap well with parentheses.
    */
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for(int i = dungeon.length - 1; i >= 0; i--) {
            for(int j = dungeon[0].length - 1; j >= 0; j--) {
                int right = j + 1 >= dungeon[0].length ? Integer.MAX_VALUE : dp[i][j + 1];
                int down = i + 1 >= dungeon.length ? Integer.MAX_VALUE : dp[i + 1][j];
                if(right == Integer.MAX_VALUE && down == Integer.MAX_VALUE) 
                    dp[i][j] = dungeon[i][j] >= 0 ? 1 : (1 - dungeon[i][j]);
                else {
                    dp[i][j] = dungeon[i][j] >= 0 ? Math.max(Math.min(right, down) - dungeon[i][j], 1) : (Math.min(right, down) - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
