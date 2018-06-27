import java.util.*;
public class BinaryTreeTraversal {
    /*
    use a stack to put root and all its left nodes, until left is null.
    when pop, add to res, and put its right and right all left into stack.
    do this untill stack is empty.
    
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> sta = new Stack<>();
            while(root != null) {
                sta.push(root);
                root = root.left;
            }
            while(!sta.isEmpty()) {
                TreeNode top = sta.pop();
                res.add(top.val);
                top = top.right;
                while(top != null) {
                    sta.push(top);
                    top = top.left;
                }
            }
        return res;
    }
}
