import java.util.*;

public class BuildBinaryTreeFromInorderAndPreorder {
	 /*
    Same logic as inorder and post order
    use a queue to put preorder, build self (poll from queue), left is s .. i - 1, right is i + 1, e
    base case if s > e return null
    
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Queue<Integer> que = new LinkedList<>();
        for(int pre : preorder) que.offer(pre);
        return build(inorder, 0, inorder.length - 1, que);
    }
    
    private TreeNode build(int[] inorder, int s, int e, Queue<Integer> que) {
        if(s > e) return null;
        TreeNode node = new TreeNode(que.poll());
        int index = -1;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == node.val) index = i;
        }
        TreeNode left = build(inorder, s, index - 1, que), right = build(inorder, index + 1, e, que);
        node.left = left;
        node.right = right;
        return node;
    }
    
    public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
}
