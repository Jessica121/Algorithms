
public class InvertBinarySearchTree {
    /*
    DFS: save left, change left to right, set right to left.
    return the root.
    no need to mind the null. set as usual.
    
    */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        // well well well, you can never be too proud.
        // never, ever be proud.
        TreeNode left = invertTree(root.left), right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
