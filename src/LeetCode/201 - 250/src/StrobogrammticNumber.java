
public class StrobogrammticNumber {
    /*
    11, 88, 16891, 69869. so around the center, left and right must be pairs of "8 8" "1 1" "6 9"
    if even, around the center.
    if odd, center - 1 and center.
    we have two pointers for left and right. in bound
    
    corner case: empty string
    */
    public boolean isStrobogrammatic(String num) {
        boolean isEven = num.length() % 2 == 0;
        if(!isEven && !isStroChar(num.charAt(num.length() / 2))) return false;
        int ptr1 = num.length() / 2 - 1, ptr2 = isEven ? num.length() / 2 : num.length() / 2 + 1;
        while(ptr1 >= 0 && ptr2 < num.length()) {
            char cha1 = num.charAt(ptr1--), cha2 = num.charAt(ptr2++);
            if(cha1 == cha2 && isStroChar(cha1)) continue;
            if(is69(cha1, cha2)) continue;
            return false;
        }
        return true;
    }
    
    private boolean isStroChar(char cha) {
        return cha == '8' || cha == '0' || cha == '1';
    }
    
    private boolean is69(char cha1, char cha2) {
        return cha1 == '6' && cha2 == '9' || (cha1 == '9' && cha2 == '6');
    }
}
