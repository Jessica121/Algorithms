
public class PalidromeNumber {
    /*
    integer manipulation: 
    check x lies within which range 0 - 10, 10 - 100, 100 - 1000, ... 2,000,000,000
    then check digit by digit:
    121
    % 10  & / 100
    /= 10
    % start of range / 10 till the todivide is 0
    todivide is the start of each range, each time todivide /= 100
    
    start range start from 1,000,000,000, then goes down by /= 10
    */
    public boolean isPalindrome(int x) {
        if(x == 0) return true;
        int start = 1000000000;
        while(start > 0) {
            if(x >= start) return checkPali(x, start);
            start /= 10;
        }
        return false;
    }
    
    private boolean checkPali(int x, int start) {
        while(start > 0) {
            if(x % 10 != x / start) return false;
            x = x % start / 10;
            start /= 100;
        }
        return true;
    }
}
