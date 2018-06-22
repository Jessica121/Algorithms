
public class RomanToInt {
    /*
    char to int, add from the begin of string, then check for IV, IX -2 for each
    XL XC -20 each, CD, CM -200 each.
    
    */
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            res += convertCharToInt(s.charAt(i));
        }
        if(s.indexOf("IV") != -1) res -= 2;
        if(s.indexOf("IX") != -1) res -= 2;
        if(s.indexOf("XL") != -1) res -= 20;
        if(s.indexOf("XC") != -1) res -= 20;
        if(s.indexOf("CM") != -1) res -= 200;
        if(s.indexOf("CD") != -1) res -= 200;
        return res;
    }
    
    private int convertCharToInt(char c) {
        switch(c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }
}
