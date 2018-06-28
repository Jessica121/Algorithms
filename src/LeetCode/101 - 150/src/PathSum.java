
public class PathSum {
    /*
    dfs, explore the left, right while substracting sum by it.
    if node is the leaf and the node val is the target, return true.
    cannot make null as the terminating condition as root itself may be null. cannot tell if its from parent or its the root.
    sum itself could be 0, could be -1. not the terminating consition.
    
    */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return sum == root.val;
        if(hasPathSum(root.left, sum - root.val)) return true;
        if(hasPathSum(root.right, sum - root.val)) return true;
        return false;
    }
}
