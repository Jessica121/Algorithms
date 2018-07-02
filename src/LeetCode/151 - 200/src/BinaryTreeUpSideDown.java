
public class BinaryTreeUpSideDown {
    /*
    recursion: if left not null, recurse on the left, return both the root and the right node.
    right.right is root,
    right.left is right. return left root and right.
    if node is a leaf, return leaf
    
    */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        return reverse(root)[0];
    }
    
    private TreeNode[] reverse(TreeNode node) {
        if(node == null) return null;
        TreeNode[] left = reverse(node.left);
        if(left == null) return new TreeNode[] {node, node};
        left[1].right = node;
        left[1].left = node.right;
        // dont forget to set node's left and right to null.
        node.right = null;
        node.left = null;
        return new TreeNode[] {left[0], left[1].right};
    }
    
    /*
    node.left.left = node.right;
    node.left.right = node
    nullify the left and right.
    do it recursivley to prevent overriding.
    base case is the node is leaf
    pass on the root.
    what happens is one node has two parents, when recursion finishes.
    
    */
    public TreeNode upsideDownBinaryTreeNeater(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        TreeNode res = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = root.right = null;
        return res;
    }
}
