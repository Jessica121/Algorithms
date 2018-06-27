import java.util.*;
public class RestoreIPAddress {
    /*
    backtrack. for each starting point, only check 1, 2, 3 length. 
    if substring is > 255, won't recurse.
    also count the number of divisions (.) we had. if already three check the current string, valid add, else dont.
    
    */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return res;
        StringBuilder sb = new StringBuilder();
        restore(s, sb, res, 0, 0);
        return res;
    }
    
    private void restore(String s, StringBuilder sb, List<String> res, int cnt, int index) {
        if(cnt == 4 || index == s.length()) {
            if(cnt == 4 && index == s.length()) {
            	// never operate add string on this level. only add or not add to the result.
                res.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }
        
        for(int i = 1; i < 4; i++) {
            if(index + i <= s.length() && Integer.valueOf(s.substring(index, index + i)) <= 255) {
            	// dealing with 000, 001.
                if(Integer.valueOf(s.substring(index, index + i)) == 0 && i > 1) continue;
                if(Integer.valueOf(s.substring(index, index + i)) > 0 && s.charAt(index) == '0') continue;
                sb.append(s.substring(index, index + i)).append('.');
                restore(s, sb, res, cnt + 1, index + i);
                sb.delete(sb.length() - i - 1, sb.length());
            }
        }
    }
}
