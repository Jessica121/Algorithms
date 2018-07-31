
public class CloestBinaryTreeValue {
    /*
    save a max and a diff.
    max = MAX, double diff Double MAX
    everytime encounter a node, calculate the diff, and update if diff is smaller than the saved one.
    then if root val > target, iteratively check left.
    else check right. 
    if root == target, return it. 
    corner case is when type is different, convert who to who? if from double to int, its lossy conversion. 
    so should be int to double.
    
    corner case: root is null. but its non empty
    
    */
    public int closestValue(TreeNode root, double target) {
        double diff = Double.MAX_VALUE;
        Integer res = null;
        while(root != null) {
            if((double) root.val == target) return root.val;
            double dif = Math.abs((double) root.val - target);
            if(diff > dif) {
                diff = dif;
                res = root.val;
            }
            if(root.val > target) root = root.left;
            else root = root.right;
        }
        return (int) res;
    }
}
