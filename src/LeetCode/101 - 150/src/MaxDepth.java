
public class MaxDepth {
    /*
    max of left and right + 1
    if null, return 0
    */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
