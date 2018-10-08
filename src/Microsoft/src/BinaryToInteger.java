
public class BinaryToInteger {
	/*
    e.g. 1010101
    iterate thru the string from the last digit to the 0th, 
    and multiple with 2^n. n could be calculated by string length - i - 1, where i is the current index in the string.
    or could init as 1, in each loop *= 2.
    add the sum together.
    same with hex to int.
    corner case: neg input.
    calculate the portion after the first digit, and substract by the max value. is the abs value of the neg. return the neg value.
    
    invalid input.
    the max length should not be exceeding 32, and everything should be 0 or 1. this is easy to check so assusme it is always valid first (?)
    */
    public static int binaryToInt(String str) {
        boolean isNeg = str.length() == 32 && str.charAt(0) == '1';
        // System.out.println(isNeg);
        int mulOfTwo = 1, sum = 0;
        for(int i = str.length() - 1; i >= (str.length() == 32 ? 1 : 0); i--) {
            sum += mulOfTwo * (str.charAt(i) - '0');
            mulOfTwo <<= 1; // should left shift by 1 not 2.
        }
        if(isNeg) sum -= Integer.MAX_VALUE;
        return sum;
    }
}
