import java.util.*;
public class PathSumII {
    /*
    store all the intermediate values in a temp list.
    only add to the res, when node is a leaf and its value is the sum.
    add the left, remove, add the right.
    
    */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        track(root, sum, temp, res);
        return res;
    }
    
    private void track(TreeNode node, int sum, List<Integer> temp, List<List<Integer>> res) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            if(node.val == sum) {
            	// add res node.
                temp.add(node.val);
                res.add(new ArrayList<>(temp));
                // remove res node.
                temp.remove(temp.size() - 1);
            }
            return;
        }
        // add root node.
        temp.add(node.val);
        track(node.left, sum - node.val, temp, res);
        track(node.right, sum - node.val, temp, res);
        temp.remove(temp.size() - 1);
    }
}
