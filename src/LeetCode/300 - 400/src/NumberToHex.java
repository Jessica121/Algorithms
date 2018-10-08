
public class NumberToHex {
	 /*
	  * 
	  *this one does not work with neg number. since i dont know how to do twos comliment
    the idea is to divide it with 16^8 to 0.
    so have one toDiv set as the integer max value, and compliment the original num if its neg.       ===> it cannot be max, since max is 2 ^ 31 - 1
    keep divide when it is not 0.
    have a stringbuilder to append the result.
    when it is empty and the result is 0, dont append.
    not that simple cuz the mapping from 10 to 16 is different.

    corner case: neg input, invalid input, 0.
    */
    public String toHex(int num) {
        int toDiv = (int)Math.pow(16, 7);
        StringBuilder sb = new StringBuilder();
        Character[] map = {'a', 'b', 'c', 'd', 'e', 'f'};
        if(num < 0) {
            num += Math.pow(2, 32);
        }
        while(toDiv != 0) {
            int digit = num / toDiv;
            num -= digit * toDiv;
            toDiv >>= 4;
            if(!(sb.length() == 0 && digit == 0)) {
                if(digit < 10) sb.append(digit);
                else sb.append(map[digit - 10]);
            }
        }
        return sb.toString();
    }
    
    /*
    a really good way is bit manipulation.
    e.g. 1111 1111
           F    F
         take the last four digit and check its value.
         then shift right by 4 digits.
         if it is neg, >> algorithm right shift will case into 11111 .... 1111, which will result in infinite loop.
         so do logical right shift. >>> 
         do it untill the num is 0.
         every char append to the front of the string.
         1011 & with 1111 will result in the last 4 digit number.
         so & with 15.
         use an array to map with each 0 - 15 to the char.
         
         corner case: input is 0.
         so take it separately.
         
         this also works for bianry, 1010101011
         and with 1 each time, take the result directly, and >>> 1
    */
    public String toHexBitSmart(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        while(num != 0) {
            sb.insert(0, map[num & 15]);
            num >>>= 4;
        }
        return sb.toString();
    }
}
