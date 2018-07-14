import java.util.*;

public class DifferentWaysToAddParenthese {
    /*
     * VERSION THAT DOES NOT WORK CUZ LIFE IS HARD ENOUGH DOES NOT MATTER HAVE ANOTHER SOLUTION THAT DOES NOT WORK.
     * 
    basic recursion + cache:
    till index i how many results, use current calculate with that and put back into map.
    one extra thing is to evaluate the string calculation: overkill using a stack
    left pare add right before digit, right right after.
    actually does not need virtually ( and ).
    start index means left paren, where it stopped is the right paren 
    evaluate from right + 1, how many, put into map.
    
   	:: this did not work because it wraps a () around single digit as well. like (1) - (1) === (1 - 1). so lots of dups
    
    */
    public List<Integer> diffWaysToComputeWrong(String input) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        return ways(0, input, map);
    }
    
    private List<Integer> ways(int index, String input, Map<Integer, List<Integer>> map) {
        List<Integer> res = new ArrayList<>();
        if(index == input.length() - 1) {
            res.add(input.charAt(index) - '0');
            return res;
        }
        if(map.containsKey(index)) return map.get(index);
        for(int i = index; i < input.length() - 2; i += 2) {
            List<Integer> next = ways(i + 2, input, map);
            int cur = eval(input.substring(index, i + 1));
            for(int num : next) res.add(eval2(cur, num, input.charAt(i + 1)));
        }
        map.put(index, res);
        return res;
    }
    
    private int eval2(int first, int sec, char sign) {
        switch(sign) {
            case '+' : return first + sec;
            case '-' : return first - sec;
            case '*' : return first * sec;
            case '/' : return first / sec;
            default: return -1;
        }
    }
    
    private int eval(String s) {
        Stack<Character> sta = new Stack<>();
        sta.push('+');
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            if(cha == '+' || cha == '-' || cha == '*') sta.push(cha);
            else {
                if(sta.peek() == '*') {
                    sta.pop();
                    int part = eval2((sta.pop() - '0'), (cha - '0'), '*');
                    sta.push((char)(part + '0'));
                } else sta.push(cha);
            }
        }
        while(!sta.isEmpty()) res += eval2(0, sta.pop() - '0', sta.pop());
        return res;
    }
    
    /*
    this really boils down to subproblem around the signs because i read the solutions. a little bit.
    obtain a list of left and right. 
    calculate base on the sign it is currently on.
    add it to the res 
    do this for each sign. i = 1, i += 2.
    base case when str.length == 1, return int value.
    the number in string could be multiple digit, not have to be single digit
    then its ok.
    
    its literaly like constructing the binary tree thing.
    recursion focus on the subproblems.
    
    */
    
    public List<Integer> diffWaysToComputeCorrect(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            char cha = input.charAt(i);
            if(cha == '+' || cha == '-' || cha == '*') {
                List<Integer> left = diffWaysToComputeCorrect(input.substring(0, i)), right = diffWaysToComputeCorrect(input.substring(i + 1));
                for(int l : left) {
                    for(int r : right) {
                        res.add(eval(l, r, cha));
                    }
                }
            }
        }
        if(res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
    
    private int eval(int first, int sec, char sign) {
        switch(sign) {
            case '+' : return first + sec;
            case '-' : return first - sec;
            case '*' : return first * sec;
            case '/' : return first / sec;
            default: return -1;
        }
    }
}
