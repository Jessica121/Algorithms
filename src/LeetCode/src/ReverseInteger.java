
public class ReverseInteger {
    /*
    int manipulation overflow
    get the last digit and add to res
    res = prev * 10 + this digit, if this digit == 0 && res == 0 ignore.
    num % 10 = this digit
    num /= 10
    
    MIN: -2,147,483,648 
    MAX: 2,147,483,647
    
    overflow:
    if(res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) return 0;
    if res > 0 && res * 10 + 7 == MAX && digit > 7 return 0
    if res < 0 && res * 10 - 8 == MIN && digit < -8 return 0

    */
    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
        	// if negative, digit will be negative
        	// when add to result, digit * 10 will still be negative, next digit will be negative as well.
            int digit = x % 10;
            if(res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) return 0;
            if(res > 0 && res == Integer.MAX_VALUE / 10 && digit > 7) return 0;
            if(res < 0 && res == Integer.MIN_VALUE / 10 && digit < -8) return 0;
            res = res * 10 + digit;
            x /= 10;
        }
        return res;
    }
}
