
public class RecoverBinarySearchTree {
    /*
    do a in-order travesal
    find the first one to swap and the last one to swap
    first one: larger than later ones. prev, this later one should be set as second at the same time as well.
    if first one is not set, set to the first one.
    last one: keep tracking the last one that less than the prev.
    if first one is set, set current as the second one, which may be overridden in later nodes.
    
    */
    private TreeNode first = null, second = null, prev = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        if(first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    
    private void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.left);

        //first is not null, set first. at the same time set second. 
        if(prev != null && first == null && prev.val >= root.val) {
            first = prev;
        }
        // but since first will not be null if set, second could be categorized together with the rest.
        if(first != null && prev.val >= root.val) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}
