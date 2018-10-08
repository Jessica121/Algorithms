import java.util.*;
public class RemoveInvalidParethese {
	/*
	 * the idea is count the number of parentheses that is imbalance. left for 1 and right for -1.
	 * the idea is backtracking.
	 * so iterate the input string, if the left count > 0 and the current char is (, then remove it and decrease the left count in the 
	 * next function call. same with right parentheses.   ======> I think it could do with a total count. ====> no baby, since )( results in 0.
	 * if the total cnt > 0, deal with (, else ), ignore other chars.
	 * when the left and right count both are 0, check valid. if valid, add the string to the res.
	 * validness is, keep a total count of left and right parentheses. if the char is right parentheses, total count must be > 0. else false.
	 * when is left, count + 1, else - 1. return the total count to 0.
	 * 
	 * the recursion pass in the res and left right count and the string itself.
	 * 
	 * corner case: empty input.
	 * 
	 * */
	
    public List<String> removeInvalidParentheses(String s) {
    	List<String> res = new ArrayList<>();
    	int leftCnt = calculateOffsetCnt(s, true), rightCnt = calculateOffsetCnt(s, false);
    	removeInvalidness(s, leftCnt, rightCnt, res);
    	return res;
    }
    
    private int calculateOffsetCnt(String s, boolean isLeft) {
    	int cnt = 0;
    	char target = isLeft ? '(' : ')';
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == target) cnt++;
    	}
    	return cnt;
    }
    
    private void removeInvalidness(String s, int leftCnt, int rightCnt, List<String> res) {
    	if(leftCnt == rightCnt) {
    		if(isValid(s)) res.add(s);
    		return;
    	}
    	for(int i = 0; i < s.length(); i++) {
    		char cha = s.charAt(i);
    		if(leftCnt > rightCnt && cha == '(') removeInvalidness(s.substring(0, i) + s.substring(i + 1), leftCnt--, rightCnt, res);
    		else if(leftCnt < rightCnt && cha == ')') removeInvalidness(s.substring(0, i) + s.substring(i + 1), leftCnt, rightCnt--, res);
    	}
    }
    
    private boolean isValid(String s) {
    	int cnt = 0;
    	for(int i = 0; i < s.length(); i++) {
    		char cha = s.charAt(i);
    		if(cha == ')' && cnt <= 0) return false;
    		else if(cha == '(') cnt++;
    		else cnt--;
    	}
    	return cnt == 0;
    }
    
    public void main(String[] args) {
    	String input = "()())()";
    	List<String> res = removeInvalidParentheses(input);
    	System.out.println(res);
    }
}
