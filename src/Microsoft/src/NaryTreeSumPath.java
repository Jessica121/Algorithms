import java.util.*;
import java.util.ArrayList;
public class NaryTreeSumPath {
	/*
	 * give an n-ary tree and a target, find a path from root sum to the target.
	 * find all path?
	 * 
	 * DFS, pass the target = target - child.
	 * main function call start from target - root
	 * if target == 0 add the node to the list.
	 * for parent calls, if the recursion list's size != 0 add itself to the list and break (to find one path)
	 * return the list.
	 * 
	 * if find all path, use a map to track child : parent, when target == 0, backtrack to get the path, add to the res list of list.
	 * 
	 * */

	//O(N) time, O(height) space.
	public static List<Node> sumPath(Node root, int target) {
		return dfs(root, target - root.val);
	}
	
	private static List<Node> dfs(Node root, int target) {
		List<Node> res = new ArrayList<>();
		if(target <= 0 || root == null) {
			if(target == 0) res.add(root);
			return res;
		}
		for(Node child : root.children) {
			List<Node> nextPath = dfs(child, target - child.val);
			if(nextPath.size() != 0) {
				nextPath.add(0, root);
				return nextPath;
			}
		}
		// return an empty list if not found.
		return res;
	}
	
	public static class Node {
		int val;
		List<Node> children;
		public Node(int v) {
			this.val = v;
			this.children = new ArrayList<>();
		}
		@Override
		public String toString() {
			return String .valueOf(this.val);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(3);
		List<Node> children = new ArrayList<>();
		children.add(new Node(2));
		children.add(new Node(4));
		children.add(new Node(6));
		root.children = children;

		Node child = children.get(2);
		children = new ArrayList<>();
		children.add(new Node(11));
		children.add(new Node(2));
		children.add(new Node(8));
		child.children = children;
		
		List<Node> sumPath = sumPath(root, 17);
		System.out.println(sumPath);
	}

}
