import java.util.*;
public class ConstructBTFromPreAndInorder {
    /*
    pre-order is the root in the queue
    in-order, decide left and right.
    find the root in in-order, build left first. start till index - 1.
    then right. as each recursion will remove the top in the queue, so it matters.
    need a queue since its not a full BT, so next in array might not be left or right if null
    left + 1,
    right + 2
    
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Queue<Integer> que = new LinkedList<>();
        for(int pre : preorder) que.offer(pre);
        return build(que, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(Queue<Integer> que, int[] inorder, int start, int end) {
        if(que.isEmpty() || start > end) return null;
        TreeNode node = new TreeNode(que.poll());
        for(int i = start; i <= end; i++) {
            if(inorder[i] == node.val) {
                node.left = build(que, inorder, start, i - 1);
                node.right = build(que, inorder, i + 1, end);
                break;
            }
        }
        return node;
    }
}
