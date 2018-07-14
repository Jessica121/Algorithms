
public class CountUnivalueSubtrees {
    /*
    return type: value and how many uni (if 0, means is not uni tree)
    if left or right how many isUni is 0, return where is -1 as well.
    else compare the value, where it needs to be left val == right.val == root.val (if not null), return self val, true. plus one with the left.many + right.many.
    
    corner case: root == null
    
    */
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        return count(root).num;
    }
    
    private Ret count(TreeNode node) {
        if(node == null) return null;
        Ret left = count(node.left), right = count(node.right);
        int num = 0;
        if(left != null) num += left.num;
        if(right != null) num += right.num;
        boolean equalLeft = left == null || (left.isUni && left.val == node.val);
        boolean equalRight = right == null || (right.isUni && right.val == node.val);
        if(equalLeft && equalRight) {
            num += 1;
            return new Ret(num, node.val, true);
        }
        return new Ret(num, node.val, false);
    }
    
    class Ret {
        int num, val;
        boolean isUni;
        public Ret(int n, int v, boolean isU) {
            this.num = n;
            this.val = v;
            this.isUni = isU;
        }
    }
}
