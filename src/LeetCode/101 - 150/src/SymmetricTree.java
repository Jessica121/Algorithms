
public class SymmetricTree {
    /*
    recursion passing up the result.
    node1 == node2 value, and node1.right, node2.left and node1.left, node2.right check.
    if one null, false. both null, return true.
    for the root, check children first. if pass root, root, everything checks up two times. 
    
    */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        // can check the left and right directly.
        return isSym(root.left, root.right);
    }
    
    private boolean isSym(TreeNode n1, TreeNode n2) {
        if(n1 == null || n2 == null) return n1 == null && n2 == null;
        return n1.val == n2.val && isSym(n1.left, n2.right) && isSym(n1.right, n2.left);
    }
}
