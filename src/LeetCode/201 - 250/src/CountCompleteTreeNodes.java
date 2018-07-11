
public class CountCompleteTreeNodes {
    /*
    for tree, must be recursioin: think about sub-problem, if them meets the condition.
    for perfect BT: the number of nodes: 2 ^ h - 1; => 2 << h - 1, where h = 1 is root.
    the thinking is recursion: if current tree is not a perfect tree, its fine. check substree.
    of substree is perfect, then its easy to return all its nodes: if left height == right height,given the tree will be complete tree
    else, return left number + 1 + right number.
    
    calculate right and left heigh, compare and return.
    if ==, return 2 << h - 1.
    else recursion.
    calculate heigh: node, bool isLeft. 
    decide goes left or right.
    
    (logn) ^ 2
    */
    public int countNodes(TreeNode root) {
        int left = hei(root, true), right = hei(root, false);
        if(left == right) return (1 << left) - 1;
        else return countNodes(root.left) + 1 + countNodes(root.right);
    }
    
    private int hei(TreeNode root, boolean isLeft) {
        int res = 0;
        while(root != null) {
            if(isLeft) root = root.left;
            else root = root.right;
            res++;
        }
        return res;
    }
}
