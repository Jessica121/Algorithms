import java.util.*;
public class ConstructBTFromPostorderAndInorder {
    /*
    put postorder into stack.....
    the rest is same with before.
    the tricky part is build the right first since it is from a stack. 
    
    */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Stack<Integer> sta = new Stack<>();
        for(int post : postorder) sta.push(post);
        return build(sta, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(Stack<Integer> sta, int[] inorder, int start, int end) {
        if(sta.isEmpty() || start > end) return null;
        TreeNode node = new TreeNode(sta.pop());
        for(int i = start; i <= end; i++) {
            if(inorder[i] == node.val) {
                node.right = build(sta, inorder, i + 1, end);
                node.left = build(sta, inorder, start, i - 1);
                break;
            }
        }
        return node;
    }
}
