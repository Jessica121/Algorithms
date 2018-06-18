
public class LargestBSTinBT {
	/*
	 * return type, min, max, isBST, size
	 * 
	 * if this > left.max && this < right.min, return left.min, right.max, true, left size + 1 + right.size
	 * else pass on the subtree has bigger size
	 * 
	 * */

	public static Return largestBST(Node root) {
		return track(root);
	}
	// O(N)
	private static Return track(Node node) {
		if(node == null) return null;
		Return left = track(node.left), right = track(node.right);
		boolean leftAndRightBST = (left == null || left.isBST) && (right == null || right.isBST);
		boolean curBST = (left == null || node.val > left.max) && (right == null || node.val < right.min);
		if(leftAndRightBST && curBST) {
			Return ret = new Return(left == null ? node.val : left.min, right == null ? node.val : right.max, true, (left == null ? 0 : left.size) + 1 + (right == null ? 0 : right.size));
			return ret;
		} else {
			Return ret = left.size > right.size ? left.clone() : right.clone();
			ret.isBST = false;
			return ret;
		}
	}
	
	public static class Return {
		int min, max, size;
		boolean isBST;
		public Return(int min, int max, boolean isBST, int size) {
			this.max = max;
			this.min = min;
			this.size = size;
			this.isBST = isBST;
		}
		
		public Return clone() {
			return new Return(this.min, this.max, this.isBST, this.size);
		}
		
		public String toString() {
			return min + ", " + max + ", " + isBST + ", " + size;
		}
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
		Node root = new Node(10);
		root.left = new Node(6);
		root.right = new Node(7);
		root.left.left = new Node(2);
		root.left.right = new Node(8);
		root.left.left.left = new Node(1);
		root.left.left.right = new Node(4);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(10);
		root.right.left = new Node(2);
		root.right.right = new Node(16);
		System.out.println(largestBST(root));
	}

}
