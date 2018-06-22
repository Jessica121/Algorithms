import java.util.*;
public class GenerateParenthese {
    /*
    Recursion: cnt for left and cnt for right
    add ( when left cnt < n
    then remove
    add ) when right < left
    then remove
    return when left == right == n;
    
    pass int the left right cnts, and string, and res
    */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n, "", 0, 0, res);
        return res;
    }
    
    private void generate(int n, String str, int left, int right, List<String> res) {
        if(left == right && left == n) {
            res.add(str);
            return;
        }
        if(left < n) {
            str += '(';
            generate(n, str, left + 1, right, res);
            str = str.substring(0, str.length() - 1);
        }
        if(right < left) {
            str += ')';
            generate(n, str, left, right + 1, res);
            str = str.substring(0, str.length() - 1);
        }
    }
}
