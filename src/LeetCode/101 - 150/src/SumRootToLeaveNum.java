
public class SumRootToLeaveNum {
    /*
    DFS, string builder build the string.
    when node is null, add the temp int value to the sum.
    
    */
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        dfs(root, sb);
        return sum;
    }
    
    private void dfs(TreeNode node, StringBuilder sb) {
        if(node.left == null && node.right == null) {
            if(sb.length() > 0) sum += Integer.valueOf(sb.toString());
            return;
        }
        if(node.left != null) {
            sb.append(node.left.val);
            dfs(node.left, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(node.right != null) {
            sb.append(node.right.val);
            dfs(node.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    /*
    DFS could also do prev * 10 + root. and dfs to next level.
    when it is the leaf, prev * 10 + leaf and add it to the res.
    res is left + right. res will pass up.
    if null return 0
    */
    public int sumNumbersNoExtraSpaceBesidesRecursionStack(TreeNode root) {
        return calculate(root, 0);
    }
    
    private int calculate(TreeNode node, int prev) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) return prev * 10 + node.val;
        int sum = 0;
        // add both left and right.
        if(node.left != null) sum += calculate(node.left, prev * 10 + node.val);
        if(node.right != null) sum += calculate(node.right, prev * 10 + node.val);
        return sum;
    }
}
