import java.util.*;

public class BinaryTreePostOrderTraversal {
    /*
    
    use one stack to track the nodes, another stack or even set to track the nodes that already checked the right half.
    push all the nodes into stack and its lefts, untill none.
    pop from the stack, put in the set also, and then trying to put everything right into stack. if top of the stack in the set, poll and add to result. else put into set and try right.
    I will just use two stacks.
    
    */
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> sta1 = new Stack<>(), sta2 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(!sta1.isEmpty() || root != null) {
            while(root != null) {
                sta1.push(root);
                root = root.left;
            }
            while(!sta2.isEmpty() && sta1.peek() == sta2.peek()) {
                res.add(sta1.pop().val);
                sta2.pop();
            }
            if(!sta1.isEmpty()) {
                sta2.push(sta1.peek());
                root = sta1.peek().right;
            }
        }
        return res;
    }
}
