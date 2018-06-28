import java.util.*;
public class BinaryTreeLevelOrderTraversalII {
    /*
    collections reverse?
    or recursion: add this level's nodes to the res of next levels. return.
    cannot pass one level. put it into a que
    */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root != null) que.offer(root);
        return bottom(que);
    }
    
    private List<List<Integer>> bottom(Queue<TreeNode> que) {
        int size = que.size();
        // if size == 0 should not recurse. else infinite loop
        if(size == 0) return new ArrayList<>();
        List<List<Integer>> res = null;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            TreeNode node = que.poll();
            list.add(node.val);
            if(node.left != null) que.offer(node.left);
            if(node.right != null) que.offer(node.right);
        }
        res = bottom(que);
        res.add(list);    
        return res;
    }
}
