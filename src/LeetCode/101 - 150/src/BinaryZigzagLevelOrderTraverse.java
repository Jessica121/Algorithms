import java.util.*;
public class BinaryZigzagLevelOrderTraverse {
    /*Can also use BFS
    just for each level, check if the size of res is even, then in order, else reverse order.
    
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if(res.size() % 2 == 1) Collections.reverse(list);
            res.add(list);
        }
        return res;
    }
}
