import java.util.*;

public class BinarySearchTreeInterator {
    /*
    in-order traversal interatively.
    put all left in the stack, till null.
    when calling next, pop and put all right left in the stack => pass to the loop condition check node.
    goes untill the stack is empty.
    its right may be null, its okay and keep checking the top of the stack.
    need a func called put all left. 
    since next and init will use it. 
    if stack is emtpy, put all left on root and get the top. and put its all right. 
    */

    Stack<TreeNode> sta;
    public BinarySearchTreeInterator(TreeNode root) {
        sta = new Stack<>();
        putAllLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !sta.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	// top is treenode not int
        TreeNode top = sta.pop();
        // put its right.
        putAllLeft(top.right);
        return top.val;
    }
    
    private void putAllLeft(TreeNode node) {
        while(node != null) {
            sta.push(node);
            node = node.left;
        }
    }
}
