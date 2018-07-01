import java.util.*;

public class EvaluateReversePolishNotation {
    /*
    use a stack, evaluate from front to end. once meet a operation, pop from top two in the stack, calculate and push the result back into the stack. go to the next token. at the end the element left in stack is the result
    
    */
    public int evalRPN(String[] tokens) {
        Stack<Integer> sta = new Stack<>();
        for(String token : tokens) {
            if(isOp(token)) {
                sta.push(calculate(sta.pop(), sta.pop(), token));
            } else sta.push(Integer.valueOf(token));
        }
        return sta.peek();
    }
    
    private int calculate(int num1, int num2, String op) {
        switch(op) {
            case "+": return num1 + num2;
            case "-": return num2 - num1;
            case "*": return num1 * num2;
            case "/": return num2 / num1;
            default: return -1;
        }
    }
    
    private boolean isOp(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }
}
