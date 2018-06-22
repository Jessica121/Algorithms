import java.util.*;
public class ValidParethese {
    /*
    if (  push ), same as {} []
    if right half, pop, compare if same.
    return stack is empty()
    */
    public boolean isValid(String s) {
        Stack<Character> sta = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '(' : sta.push(')');
                    break;
                case '[' : sta.push(']');
                    break;
                case '{' : sta.push('}');
                    break;
                case ')' :
                case ']' :
                case '}' : if(sta.isEmpty() || sta.pop() != s.charAt(i)) return false;
                    break;
            }
        }
        return sta.isEmpty();
    }
}
