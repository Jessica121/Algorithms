
public class UglyNumber {
    /*
    anything not divisible by 2, 3, 5 (exclude 1) is not ugly.
    recursive. check % 2, else 3, else 5, else false.
    return after division.
    
    corner case: neg. -12 ? 
                input is zero!
    
    things relate to numbers: corner case: 1, neg, 0, small ones. and overflow.
    */
    public boolean isUgly(int num) {
        if(num == 0 || num == 1) return num == 0 ? false : true;
        if(num % 2 == 0) return isUgly(num / 2);
        else if(num % 3 == 0) return isUgly(num / 3);
        else if(num % 5 == 0) return isUgly(num / 5);
        else return false;
    }
}
