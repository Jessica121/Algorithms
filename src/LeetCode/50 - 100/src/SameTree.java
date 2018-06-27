
public class SameTree {
    /*
    first, two nodes are same.
    then, left same right same..
    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return q == null && p == null;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
