
public class MinDepthOfBinaryTree {
    /*
    min of left and right + 1
    */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        // mind that left and right is null, return 1 + the other child. 
        // or the null will always counts to 1.
        // dont think it as a full tree.
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
