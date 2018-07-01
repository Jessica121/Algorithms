
public class BinaryTreeMaxPathSum {
    /*
    need to return the max path and add itself and return both. 
    partial max path != total max path.
    for each node, return both if both are positive, and bigger one if neg exist.
    left max and right max, and left + right + self, update the biggest one on the go, and return the bigger branch.
    similar to max subarray sum 
    */
    
    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        check(root);
        return max;
    }
    
    private int check(TreeNode root) {
        if(root == null) return 0;
        int left = check(root.left), right = check(root.right);
        if(left < 0 && right < 0) max = Math.max(max, root.val);
        else if(left < 0 || right < 0) max = Math.max(Math.max(left, right) + root.val, max);
        else max = Math.max(max, left + right + root.val);
        return left < 0 && right < 0 ? root.val : Math.max(left, right) + root.val;
    }
}
