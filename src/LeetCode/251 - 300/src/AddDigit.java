
public class AddDigit {
    /*
    recursion, check number is less than 10, if so return.
    then add 0 to 10 digits.
    return recursion to that.
    
    */
    public int addDigits(int num) {
        if(num < 10) return num;
        int res = 0;
        for(int i = 0; i < 10; i++) {
            res += num % 10;
            num /= 10;
            if(num == 0) break;
        }
        return addDigits(res);
    }
}
