
public class WildcardMatching {
    /*
    Start from the end of the string, if both char, need two next match. if one is ? also need both next match.
    if one is *, need both next match or ignore * and match two strings.
    
    */
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // it may have more *** in p at the end.
        for(int i = p.length() - 1; i >= 0; i--) {
            if(p.charAt(i) == '*') dp[s.length()][i] = true;
            else break;
        }
        
        dp[s.length()][p.length()] = true;
        for(int j = p.length() - 1; j >= 0; j--) {
            for(int i = s.length() - 1; i >= 0; i--) {
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') dp[i][j] = dp[i + 1][j + 1];
                else if(p.charAt(j) == '*') dp[i][j] = dp[i + 1][j + 1] || dp[i][j + 1] || dp[i + 1][j];
            }
        }
        return dp[0][0];
    }
}
