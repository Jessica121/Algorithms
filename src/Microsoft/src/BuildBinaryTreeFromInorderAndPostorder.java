import java.util.*;

public class BuildBinaryTreeFromInorderAndPostorder {
	/*
	    from the post order we know the root which at last, find in the inorder this root within the range of the in order, its right is range i + 1 till end
	    left is 0 till i - 1
	    put the postorder into a stack, build right first, then left. since post order is left and right, in stack right to left re-build
	    for each root, find in the range of the in order to set it as the root, build right, start from its index + 1, then left 0 - index - 1. if start > end, return null
	    pop from the post-order each time.
	    N^2 time.
	    
	    post order we can use a stack since the top is root, in - order left subtree is left, right subtree is right.
	    if pre-order, may use a queue.
	    Tree: recursion, left subtree same as right subtree.
	    null node base case in recursion.
	    rebuild tree from a X-order, use its characteristic

	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Stack<Integer> sta = new Stack<>();
		for(int p : postorder) sta.push(p);
		return build(inorder, 0, inorder.length - 1, sta);
	}
	
	private TreeNode build(int[] inorder, int s, int e, Stack<Integer> sta) {
		if(s > e) return null;
		TreeNode root = new TreeNode(sta.pop());
		int index = -1;
		for(int i = s; i <= e; i++) {
		    if(inorder[i] == root.val) {
		        index = i;
		        break;
		    }
		}
		root.right = build(inorder, index + 1, e, sta);
		root.left = build(inorder, s, index - 1, sta);
		return root;
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
