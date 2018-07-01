import java.util.*;
public class PalidromicPartitionII {
    /*
    check for all palidrom substring, for all its child, take the min and return.
    use a map to store index : min cut.
    return the num of cut.
    
    */
    public int minCut(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        return min(s, 0, map);
    }
    
    private int min(String s, int index, Map<Integer, Integer> map) {
    	// when string is empty, no cut needed, but not 0. e.g."b" = 'b' + '' at this time b cut is 0.
        if(index == s.length()) return -1;
        if(map.containsKey(index)) return map.get(index);
        int min = s.length() - 1; // max cut would be cut between each char.
        for(int i = index + 1; i <= s.length(); i++) {
            String candi = s.substring(index, i);
            if(isPali(candi)) {
                int next = min(s, i, map);
                if(next + 1 < min) min = next + 1;
            }
        }
        map.put(index, min);
        return min;
    }
    
    private boolean isPali(String candi) {
        int ptr1 = 0, ptr2 = candi.length() - 1;
        while(ptr1 < ptr2) {
            if(candi.charAt(ptr1) != candi.charAt(ptr2)) return false;
            ptr1++;
            ptr2--;
        }
        return true;
    }
    
    /*
    DP solution really is two loops, j from i to s.length.
    if i to j is palidrom, them dp[i] = min(dp[i], dp[j] + 1)
    j == length, dp[j] = -1.
    to check pali quickly: 2D array, if i == j && dp[i + 1][j - 1] == 1 (zero cut means palidrome)
    then dp[i][j] = min(dp[i][j], 1 + dp[j][length()]) if i == j && dp[i + 1][j - 1] == 1
    init as s.length() - 1
    
    the center means it is a palidro or not. the last col means min cuts, from this row to the end.
    */
    public int minCutDP(String s) {
        if(s.isEmpty()) return 0;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        dp[s.length()][s.length()] = -1;
        for(int i = s.length() - 1; i >= 0; i--) {
        	// init as max possible: s.length - 1.
            dp[i][s.length()] = s.length() - 1;
            for(int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j - i <= 1 || dp[i + 1][j - 1] == 1) { // 1 means it is a palidrom
                        dp[i][j] = 1;
                        dp[i][s.length()] = Math.min(dp[i][s.length()], 1 + dp[j + 1][s.length()]);
                    }
                }
            }
        }
        return dp[0][s.length()];
    }
}
