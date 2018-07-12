
public class LCAofBST {
    /*
    Take p and q compare with the root. if root - p * q - root >= 0 return root
    else go left if root > p else right
    corner case is when p and q not in the tree, go thru it and validate.
    p == q return itself but it wont happen.
    one of them is null. return the other one.
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == null ? q : p;
        if((root.val - p.val) * (q.val - root.val) >= 0) return root;
        else return lowestCommonAncestor((root.val > p.val ? root.left : root.right), p, q);
    }
}
