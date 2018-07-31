import java.util.*;
public class BinaryTreePath {
    /*
    self append to left paths, and right paths, add to the res and return
    so need caching? no, dfs
    time O(N)
    
    add self value and -> 
    call left and right.
    if node == null, add to res substring(0, length - 2)
    then remove self and ->
    
    */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        track(root, res, "");
        return res;
    }
    
    private void track(TreeNode node, List<String> res, String sb) {
        if(node == null) return;
        int oriLen = sb.length();
        // need to check leaf at parent level, not itself level -> if the node is null..
        if(node.left == null && node.right == null) {
            sb += node.val;
            res.add(sb);
            sb = sb.substring(0, oriLen);
            return;
        }
        sb += node.val;
        sb += "->";
        track(node.left, res, sb);
        track(node.right, res, sb);
        sb = sb.substring(0, oriLen);
    }
}
