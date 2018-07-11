import java.util.Stack;

public class BasicCalculatorII {
    /*
    only leave + and - in the stack.
    when meet * or /, pop the top of the stack and * or / with the current. push the result onto the stack.
    when sign + - * /, push it directly.
    when digit, get the whole range of that and check if the top is * or /, if so, calculate the result and put in.
    else if the stack is empty, push a + to it.
    else push directly.
    then run the stack to calculate the result. 
    */
    public int calculate(String s) {
        Stack<String> sta = new Stack<>();
        int i = 0, res = 0;
        while(i < s.length()) {
            char cha = s.charAt(i);
            if(cha != ' ') {
                if(isSign(cha)) sta.push("" + cha);
                else { // digit
                    int j = i;
                    while(i < s.length() && Character.isDigit(s.charAt(i))) i++;
                    if(sta.isEmpty()) sta.push("+");
                    // after that the stack will never be empty. and need to push the number itself too.
                    // string value comparison is equals i thought you know this.
                    if(sta.peek().equals("*") || sta.peek().equals("/")) sta.push(cal(sta.pop(), sta.pop(), s.substring(j, i)));
                    else sta.push(s.substring(j, i));
                    i--;
                }
            }
            i++;
        }
        while(!sta.isEmpty()) res += cal(sta.pop(), sta.pop());
        return res;
    }
    
    private boolean isSign(char cha) {
        return cha == '+' || cha == '-' || cha == '*' || cha == '/';
    }
    
    private String cal(String sign, String upper, String downer) {
        int res = 0;
        if(sign.equals("*")) res = Integer.valueOf(upper) * Integer.valueOf(downer);
        else res = Integer.valueOf(upper) / Integer.valueOf(downer);
        return String.valueOf(res);
    }
    
    private int cal(String num, String sign) {
        return sign.equals("+") ? Integer.valueOf(num) : -Integer.valueOf(num);
    }
}
