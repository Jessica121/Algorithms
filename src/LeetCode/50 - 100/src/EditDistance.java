
public class EditDistance {
    /*
    it is a substring strucutre, each substring can be seen as a new problem, and total string can build upon it.
    dynamic programming change substring matching into total string matching.
    dp[wrd1.length + 1][wrd2.length + 1]. the right down cell is 0.
    each word match to the other empty string is the length of the substring.
    cat 
    cbt
    if the char is the same at index i and j, it does not need to be changed, min distance is i + 1, j + 1
    else it could be 1. replace : (i + 1, j + 1) + 1
                     2. add: add i: (i + 1, j) + 1
                     3. add: add j: (i, j + 1) + 1            the min of three
    
    */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        initilize(dp);
        for(int i = word1.length() - 1; i >= 0; i--) {
            for(int j = word2.length() - 1; j >= 0; j--) {
                if(word1.charAt(i) == word2.charAt(j)) dp[i][j] = dp[i + 1][j + 1];
                else {
                    dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
                }
            }
        }
        return dp[0][0];
    }
    
    private void initilize(int[][] dp) {
        for(int i = 0; i < dp.length; i++) dp[i][dp[0].length - 1] = dp.length - i - 1;
        for(int i = 0; i < dp[0].length; i++) dp[dp.length - 1][i] = dp[0].length - i - 1;
    }
}
