import java.util.*;

public class BinaryTreeRightSideView {
    /*
    BFS, when queue left with one node, add it to the res.
    
    */
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root != null) que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if(i == size - 1) res.add(node.val);
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
        }
        return res;
    }
    
    /*
    level order, but right first. right first DFS.
    so when the level has not been added to the res, add it.
    right, level + 1,
    left, level + 1
    if res.size() == level, meaning this is the first in this level. and right first. so add it.
    continue recurse.
    
    */
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recurse(root, res, 0);
        return res;
    }
    
    private void recurse(TreeNode node, List<Integer> res, int level) {
        if(node == null) return;
        if(level == res.size()) res.add(node.val);
        recurse(node.right, res, level + 1);
        recurse(node.left, res, level + 1);
    }
}
