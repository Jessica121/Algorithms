import java.util.Stack;

public class VerifyPreorderSeqInBST {
    /*
    my thinking is push them into stack.
    and keep a root value. 
    if current > top of stack, pop and update the root by poped value.
    then push the current element.
    if anything less than top of the stack but > than root, return false.
    else push it into stack.
    
    if its on left subtree, don't update the root as it must less than top of the stack
    */
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> sta = new Stack<>();
        int root = Integer.MIN_VALUE;
        for(int pre : preorder) {
            if(sta.isEmpty() || sta.peek() < pre) {
                while(!sta.isEmpty() && sta.peek() < pre) {
                    root = sta.pop();
                }
                sta.push(pre);
            } else {
                if(pre < root) return false;
                sta.push(pre);
            }
        }
        return true;
    }
}
