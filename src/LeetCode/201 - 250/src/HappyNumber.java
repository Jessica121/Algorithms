
public class HappyNumber {
    /*
    recursion: result put into recursion, if next true, return true.
    if result to 2 probably wont be a happy number.
    
    */
    public boolean isHappy(int n) {
        if(isMulOf2(n) || n == 0) return false;
        if(n == 1) return true;
        int res = 0;
        while(n != 0) {
            int seq = n % 10;
            res += seq * seq;
            n /= 10;
        }
        return isHappy(res);
    }
    
    private boolean isMulOf2(int n) {
    	// mind checking numbers like 200 involves n % 10 == 0, not just n > 10. cuz it will not work for things like 210!
        while(n > 10 && n % 10 == 0) n /= 10;
        return n == 2;
    }
}
