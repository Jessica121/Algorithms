
public class BalancedBinaryTree {
    /*
    could return true false and the max height of left, right, + 1
    the false could also be indicated by a invalid height, anything < 0
    check root null first, return 0
    then check left, right recursion, if any of them is -1, return -1. 
    else return max of left and right + 1
    
    */
    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }
    
    private int check(TreeNode node) {
        if(node == null) return 0;
        int left = check(node.left), right = check(node.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
