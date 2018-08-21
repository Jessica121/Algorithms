import java.util.*;
public class ExpressionAddOperators {
    /*
    parse thru the string, from start index to i, check +, -, *.
    i till num string length inclusive.
    for + and -, just + or - the value of the substring.
    for multiple, a + b * c, substract the last add from sum (a + b) then lastAdd * mul
    when index == num.length, add the temp string into result.
    
    corner case: first number, for * won't work. since sum == 0, but last added is value. so the first number is individual, and handles the corner case of non-first vals as well.
                 when the string starts with 0.
                 string parse into int: obviously overflow.
    
    */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        calculate(num, target, 0, 0, 0, "", res);
        return res;
    }
    
    private void calculate(String num, long target, long sum, int index, long lastAdded, String temp, List<String> res) {
        if(index == num.length()) {
            if(target == sum) res.add(temp);
            return;
        }
        
        for(int i = index + 1; i <= num.length(); i++) {
            long val = Long.valueOf(num.substring(index, i));
            if(index == 0) {
                calculate(num, target, val, i, val, temp + val, res);
            } else {
                calculate(num, target, sum + val, i, val, temp + '+' + val, res);
                calculate(num, target, sum - val, i, -val, temp + '-' + val, res);
                calculate(num, target, sum - lastAdded + lastAdded * val, i, lastAdded * val, temp + '*' + val, res);
            }
            if(num.charAt(index) == '0') break;
        }
    }
}
