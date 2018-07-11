import java.util.*;

public class BasicCalculator {
    /*
    push everything into stack. 
    mind when meet left paren and the stack is empty, push + first then it.
    or if it is a digit and the sta is not empty but the top is (, push a + first
    when meet a ), evaluate save result from the stack, untill top is (. pop the ( and push res into stack.
    after eval the sta to get the result.
    
    */
    public int calculate(String s) {
        Stack<String> sta = new Stack<>();
        int i = 0, res = 0, temp = 0;
        while(i < s.length()) {
            char cha = s.charAt(i);
            if(cha != ' ') {
                if(cha == '(') {
                	// key point here is to keep things consistent: when sta is empty and want to push a ( or number, push a + sign first.
                    if(sta.isEmpty()) sta.push("+");
                    sta.push("(");
                } else if(Character.isDigit(cha)) {
                    int j = i;
                    while(i < s.length() && Character.isDigit(s.charAt(i))) i++;
                    // also when want to push a number check if the stack is empty or top is ( then push a + sign.
                    if(sta.isEmpty() || sta.peek().equals("(")) sta.push("+");
                    sta.push(s.substring(j, i));
                    i--;
                } else if(cha == '+' || cha == '-') sta.push(String.valueOf(cha));
                else {
                    while(!sta.isEmpty() && !sta.peek().equals("(")) temp += eval(sta.pop(), sta.pop());
                    sta.pop(); // as we meet a ) and its is sure to valid, we must have ( to pop, so no need to check empty stack.
                    sta.push(String.valueOf(temp));
                    temp = 0;
                }
            }
            i++;
        }
        while(!sta.isEmpty()) res += eval(sta.pop(), sta.pop());
        return res;
    }
    
    private int eval(String num, String sign) {
        int val = Integer.valueOf(num);
        return sign.equals("-") ? -val : val;
    }
}
