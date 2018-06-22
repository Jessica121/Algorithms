
public class RegularExpressionMatching {
    /*
    substring dp
    break down string, match into p
    i = s.len - 1 .. 0
        j = t.length - 1 .. 0
    s.char meet with a "*" in p or not match, check next in p; [i][j + 1]
    if char in s and p equal, check both + 1. [i + 1][j + 1]
    return dp[0][0]
    
    core thinking : a | ab
    				a | *b if first ones matches, we check ab and a*b
    				if not match, not matching, if doesn't follow by a star
    */
    public boolean isMatch(String s, String t) {
        if(t.isEmpty()) return s.isEmpty();
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        dp[s.length()][t.length()] = true;
        // bound s.length() for empty string "" matches a*a*a*
        for(int i = s.length(); i >= 0; i--) {
            for(int j = t.length() - 1; j >= 0; j--) {
                // dp[i][j + 2] doesnt need match, just need a star at the second char
                if(i < s.length() && (s.charAt(i) == t.charAt(j) || t.charAt(j) == '.')) {
                    if(j + 1 < t.length() && t.charAt(j + 1) == '*' && i < s.length()) dp[i][j] = dp[i + 1][j] || dp[i][j + 2]; // if match, can also check dp[i][j + 2]
                    else dp[i][j] = dp[i + 1][j + 1];
                } else if(j + 1 < t.length() && t.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2];
                } //else dp[i][j] = dp[i][j + 1]; => not work for "" & c* -> will result in match while not. nor for aa & baa.
            }
        }
        return dp[0][0];
    }
}
