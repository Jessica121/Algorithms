
public class ValidNumber {
    /*
    1. ignore blank space up front, if meet alphabets rather than ., false
    2. while loop check digit and . e break when blank space or alphabets other than e (return false). check two if see . and three if e
    3. continue check the rest of the string, if anything other than blank space return false
    
    
    */
    public boolean isNumber(String s) {
        int i = 0;
        s = s.trim();
        while(i < s.length()) {
            if(s.charAt(i) == ' ') i++;
            else if(Character.isDigit(s.charAt(i)) || s.charAt(i) == '.' || s.charAt(i) == '+' || s.charAt(i) == '-') break;
            else return false;
        }
        int dotCnt = 0, eCnt = 0;
        if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        while(i < s.length()) {
            char cha = s.charAt(i);
            // System.out.println(cha);
            if(cha == '.') {
                if(dotCnt == 1) return false;
                if(i + 1 == s.length() && (i - 1 < 0 || !Character.isDigit(s.charAt(i - 1)))) return false;
                if(i + 1 < s.length()) {
                    if(s.charAt(i + 1) == 'e' && i == 0) return false;
                    else if(!(Character.isDigit(s.charAt(i + 1)) || s.charAt(i + 1) == 'e')) return false;
                }
                dotCnt++;
                i++;
            } else if(Character.isDigit(cha)) i++;
            else break;
        }
        while(i < s.length()) {
            char cha = s.charAt(i);
            if(cha == 'e') {
                if(eCnt == 1) return false;
                if(i - 1 < 0 || !(Character.isDigit(s.charAt(i - 1)) || s.charAt(i - 1) == '.') || i + 1 == s.length() 
                   || !(Character.isDigit(s.charAt(i + 1)) || s.charAt(i + 1) == '+' || s.charAt(i + 1) ==  '-')) return false;
                eCnt++;
                i++;
            } else if(Character.isDigit(cha)) i++;
            else if(cha == '+' || cha == '-') {
                if(i - 1 < 0 || s.charAt(i - 1) != 'e' || i + 1 == s.length()) return false;
                i++;
            } else return false;
        }
        return s.length() > 0;        
    }
}
