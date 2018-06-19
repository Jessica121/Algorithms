
public class IntegerToRoman {
	/*
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    
    recursive solution, check from bigger ones. 
    if n > 1000, cnt = n / 1000
    append cnt M, then append to recursively n % 1000
    return the concat string.
    same for 500, 100, 50, 10, 5, 1.
    only to check 400, 90, 9, 4 every time. 
    
    1994 -> MCMIXIX
    */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if(num == 0) return "";
        String next = "";
        if(num >= 1000) {
            int cnt = num / 1000;
            for(int i = 0; i < cnt; i++) sb.append('M');
            next = intToRoman(num % 1000);
        } else if(num >= 100) {
            int cnt = num / 100;
            if(cnt == 4) sb.append("CD");
            else if(cnt == 9) sb.append("CM");
            else {
                if(cnt >= 5) {
                    sb.append('D');
                    cnt -= 5;
                }
                for(int i = 0; i < cnt; i++) sb.append('C');
            }
            next = intToRoman(num % 100);
        }  else if(num >= 10) {
            int cnt = num / 10;
            if(cnt == 9) {
                sb.append("XC");
            } else if(cnt == 4) sb.append("XL");
            else {
                if(cnt >= 5) {
                    sb.append('L');
                    cnt -= 5;
                }
                for(int i = 0; i < cnt; i++) sb.append('X');
            }
            next = intToRoman(num % 10);
        } else {
            if(num == 4) sb.append("IV");
            else if(num == 9) sb.append("IX");
            else {
                if(num >= 5) {
                    sb.append('V');
                    num -= 5;
                }
                for(int i = 0; i < num; i++) sb.append('I');
            }
            next = intToRoman(num % 1);
        }
        sb.append(next);
        return sb.toString();
    }
}
