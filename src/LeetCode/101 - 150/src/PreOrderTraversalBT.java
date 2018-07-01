import java.util.*;

public class PreOrderTraversalBT {
    /*
    still need to do it recursively even if its is trivial, :]
    have a temp list, basically the result, append root val to it, and left and right.
    if node is null, dont so anything, just return.
    
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recurse(root, res);
        return res;
    }
    
    private void recurse(TreeNode node, List<Integer> res) {
        if(node == null) return;
        res.add(node.val);
        recurse(node.left, res);
        recurse(node.right, res);
    }
}
