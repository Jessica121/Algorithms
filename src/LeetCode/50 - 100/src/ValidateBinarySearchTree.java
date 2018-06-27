
public class ValidateBinarySearchTree {
    /*
    return both the min and max in this tree
    root > left.max && root < right.min
    return left min and right max
    
    */
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValid(root).isBST;
    }
    
    private Ret isValid(TreeNode root) {
    	// if is null node, return null.
        if(root == null) return null;
        Ret left = isValid(root.left), right = isValid(root.right);
        // check left and right not null
        if((left != null && !left.isBST) || (right != null && !right.isBST)) return new Ret(root.val, root.val, false);
        // check left and right not null
        boolean leftCorrect = left == null ? true : root.val > left.max;
        boolean rightCorrect = right == null ? true : root.val < right.min;
        // return tyope based on left and right not null.
        if(leftCorrect && rightCorrect) return new Ret(left == null ? root.val : left.min, right == null ? root.val : right.max, true);
        else return new Ret(root.val, root.val, false);
    }
    
    class Ret {
        int min, max;
        boolean isBST;
        public Ret(int min, int max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
}
