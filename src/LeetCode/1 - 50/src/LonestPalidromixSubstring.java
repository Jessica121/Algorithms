
public class LonestPalidromixSubstring {
    /*
    Expand around the center of each character, string pattern find in the whole string:
    start from (i, i) and (i, i + 1)
    expand involves checking i, j, and expand into i - 1, j + 1, if same, furthur, return the max len.
    */
    //O(N^2)
    public String longestPalindrome(String s) {
        int res = 0, start = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int max = Math.max(len1, len2);
            if(max > res) {
                if(max == len1) start = i - (len1 - 1) / 2;
                else start = (i + 1) - len2 / 2;
                res = max;
            }
        }
        return s.substring(start, start + res);
    }
    
    private int expand(String s, int a, int b) {
        int len = 0;
        while(a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b)) {
            len += a == b ? 1 : 2;
            a--;
            b++;
        }
        return len;
    }
    
    
    /*
    if char(i) == char(j) && dp[i + 1][j - 1] != 0. dp[i][j] = dp[i + 1][j - 1] + 2
    else == 0
    i = len - 1 .. 0,
        j = i .. len 
    dp[i][i] == 1
    if j - i >= 1, no need for dp[i + 1][j - 1]
    
    */
    public String longestPalindromeDP(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int res = 0, start = 0;
        // if dp is check i + 1, then i start from end, decrease. 
        // check j - 1, then j increase
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j - i <= 1) dp[i][j] = j - i + 1;
                    else dp[i][j] = dp[i + 1][j - 1] != 0 ? dp[i + 1][j - 1] + 2 : 0;
                    if(dp[i][j] > res) {
                        start = i;
                        res = dp[i][j];
                    }
                } else dp[i][j] = 0;
            }
        }
        // for(int i = 0; i < dp.length; i++) System.out.println(Arrays.toString(dp[i])); // print dp matrix.
        return s.substring(start, start + res);
    }
}
