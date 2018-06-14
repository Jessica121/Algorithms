import java.util.*;
public class ConstructBinarySearchTreefromPostorderTraversal {
	/*
	 * Given a post order traverse of a BST, reconstruct the tree.
	 * 
	 * Tree: recursion;
	 * BST: sorted in inorder.
	 * 
	 * e.g. 1,4,3,6,8,7,5
	 * 
	 * we know the last one is the root. everything before that and larger than that belongs to the right subtree.
	 * but have to maintain the order.
	 * cannot use quick select, is unstable
	 * 1,4,3,6,8,7,5 => 1,4,3,5,6,8,7
	 * 1,4,3,6,8,2,7,5 => 1,4,3,6,8,2,5,7
	 * 
	 * just go thru the list, put into small list and big list, recursion small as left subtree, big as right
	 * return the root.
	 * */
	
	// O(N^2)
	public static Node constructBinarySearchTreefromPostorderTraversal(List<Integer> traverse) {
		if(traverse.size() == 0) return null;
		List<Integer> small = new ArrayList<>(), big = new ArrayList<>();
		Node root = new Node(traverse.get(traverse.size() - 1));
		for(int i = 0; i < traverse.size() - 1; i++) {
			int value = traverse.get(i);
			if(value < root.val) small.add(value);
			else big.add(value);
		}
		root.left = constructBinarySearchTreefromPostorderTraversal(small);
		root.right = constructBinarySearchTreefromPostorderTraversal(big);
		return root;
	}
	
	public static class Node {
		int val;
		Node left, right;
		public Node(int v) {
			this.val = v;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		// 1,4,3,6,8,7,5
		List<Integer> list = new ArrayList<>();
//		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
		list.add(5);list.add(4);list.add(3);list.add(2);list.add(1);list.add(0);
		Node root = constructBinarySearchTreefromPostorderTraversal(list);
		print(root);
	}
	
	private static void print(Node root) {
		if(root == null) {
			System.out.print("X");
		} else {
			print(root.left);
			System.out.print(root.val);
			print(root.right);
		}

	}

}
