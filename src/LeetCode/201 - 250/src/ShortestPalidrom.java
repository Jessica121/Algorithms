
public class ShortestPalidrom {
    /*
    since it has to append to the front, so check a longest palidrom starting from index 0.
    then append j + 1, to front, till end. append to front always.
    
    */
    public String shortestPalindrome(String s) {
        int end = paliFromStart(s);
        if(end == s.length()) return s;
        StringBuilder sb = new StringBuilder(s);
        for(int i = end; i < s.length(); i++) sb.insert(0, s.charAt(i));
        return sb.toString();
    }
    
    /*
    if char i == char j && dp[i + 1][j - 1] = true. this is true.
    i + 1 > j
    two loops. i = 0 .. len
    j = 0 .. i, update the max len(i + 1) only when j == 0 and dp == true.
    since j is before i, use dp[j][i]
    
    */
    private int paliFromStart(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        // one forward, one backward, different direction if in the dp use different direction ref.
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j >= 0; j--) {
                if(s.charAt(i) == s.charAt(j)) dp[j][i] = j + 1 >= i ? true : dp[j + 1][i - 1];
                if(dp[j][i] && j == 0) res = i + 1;
            }
        }
        return res;
    }
    
    /*
    Another way to aviod MLE, is to take (0, i) substring, check (0, 2i) and (0, 2i + 1) is a palidrom or not.
    i ranges from 1 to len / 2 obviously.
    if upper bound exceed, ignore.
    save upper bound + 1 as the result, if meet not palidrome, stop immediately.
    */
    public String shortestPalindromeNoDP(String s) {
        int end = 0;
        for(int i = 0; i <= s.length() / 2; i++) {
            if(2 * i + 1 < s.length() && isPali(s, 0, 2 * i + 1)) end = 2 * i + 1;
            else if(2 * i < s.length() && isPali(s, 0, 2 * i)) end = 2 * i;
        }
        // this will work for "a", as end == 0, sb will init as itself and append nothing.
        if(end == s.length()) return s;
        StringBuilder sb = new StringBuilder(s);
        for(int i = end + 1; i < s.length(); i++) sb.insert(0, s.charAt(i));
        return sb.toString();
    }
    
    private boolean isPali(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
