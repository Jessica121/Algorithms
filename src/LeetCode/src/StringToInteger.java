
public class StringToInteger {
    /*
     * string manipulation and building integers.
     * if things happen in order, and after the order cannot happen in the dame way, just check in order. 
     * if goes to next step will never check like this.
     * 
    run a while loop to eliminate the blank space first, 
    then check the char is '-' or '+' or digit.
    Integer manipulation and string manipulation, check overflow.
    if sign == '-' isNeg = true
    then use a res, res = res * 10 + digit. char - 'a'
    if isNeg && res < MIN / 10 || !isNeg && res > max / 10
    or == MIN / MAX / 10, digit > 7 || < -8, return MAX / MIN base on isNeg
    
    */
    public int myAtoi(String str) {
        int res = 0, i = 0;
        boolean isNeg = false;
        // white space.
        while(i < str.length() && str.charAt(i) == ' ') i++;
        // potential signs
        if(i < str.length() && str.charAt(i) == '-') {
            isNeg = true;
            i++;
        } else if(i < str.length() && str.charAt(i) == '+') {
            i++;
        } 
        // handle digits only 
        while(i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if(isNeg) {
                if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > 8)) 
                    return Integer.MIN_VALUE;
            } else {
                if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > 7)) 
                    return Integer.MAX_VALUE;
            } 
            res = res * 10 + digit;
            i++;
        } 
        return isNeg ? -res : res;
    }
}
