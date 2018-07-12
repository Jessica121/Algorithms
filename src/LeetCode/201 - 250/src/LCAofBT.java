
public class LCAofBT {
    /*
    if root == q or q, return root.
    else dfs, left != null && right != null, return root
    else return the non null one. or null.
    
    corner case: root null, p null, q null
    p q not in the tree
    p == q
    
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q), right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }
    
    /*
     * iterative way really is just to use a stack traverse and a map of child : parent.
     * 
     * 
     * */
}
