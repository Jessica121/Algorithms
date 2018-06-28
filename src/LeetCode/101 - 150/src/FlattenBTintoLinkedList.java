
public class FlattenBTintoLinkedList {
	   /*
    maintain a previous when doing recursion, everytime append to next of prev and set itself as the previous
    save right, root append to previous, set previous, flatten left.
    flatten right. 
    */
    TreeNode prev = new TreeNode(-1);
    public void flatten(TreeNode root) {
        if(root == null) return;
        prev.right = root;
        prev = root;
        TreeNode right = root.right;
        flatten(root.left);
        // nullify the left. when reassigning lots of pointers.
        root.left = null;
        flatten(right);
    }
}
