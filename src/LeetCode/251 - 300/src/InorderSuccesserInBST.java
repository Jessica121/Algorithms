
public class InorderSuccesserInBST {
    /*
    the idea is to do a bianry search, for the target node value.
    if node val <= target value, go right.
    else save the node val as the candidate and go left.
    till the node is null. condition be while node != null.
    return the candidate. init as null.
    
    corner case: root is null, candidate still null.
    
    */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode candidate = null;
        while(root != null) {
            if(root.val <= p.val) root = root.right;
            else {
                candidate = root;
                root = root.left;
            }
        }
        return candidate;
    }
}
