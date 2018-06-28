import java.util.*;
public class BinaryTreeLevelOrderTraversal {
    /*
    Use a queue. add level by level.
    in each level, create a new list, and for i = 0 .. size, add and offer the children as well
    till the queue is empty()
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root != null) que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                list.add(node.val);
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
