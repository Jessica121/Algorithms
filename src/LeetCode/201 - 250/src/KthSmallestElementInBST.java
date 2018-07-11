import java.util.*;

public class KthSmallestElementInBST {
    /*
    i would calculate the rank of each node and cache them for efficient loop ups.
    rank if left size + 1.
    return left size + 1 + right size.
    if node rank == k return it.
    else if rank > k, go left, k 
    else go right, k - rank.
    
    */
    public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> map = new HashMap<>();
        getSizeAndSetRank(root, map);
        return kth(root, k, map);
    }
    
    private int getSizeAndSetRank(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int left = getSizeAndSetRank(root.left, map), right = getSizeAndSetRank(root.right, map);
        map.put(root, left + 1);
        return left + 1 + right;
    }
    
    private int kth(TreeNode node, int k, Map<TreeNode, Integer> map) {
        int rank = map.get(node);
        if(rank == k) return node.val;
        else if(rank > k) return kth(node.left, k, map);
        else return kth(node.right, k - rank, map);
    }
    
    /*
     * Follow up:
     * What if the BST is modified (insert/delete operations) often 
     * and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
     * 
     * 
     * using indexed tree:
     * insert: increase index for every node it encounters, navigate to the correct place: log n, also set the new node index = 1.
     * delete: find the targe logn, record the parent at the same time. 
     * reset the other branch of the del node takes another logn, same thing as insert, but index increase by the size of the subtree
     * for every node it encounters.
     * find k: calculate the rank first: left index + 1, and navigate left, right or return itself, takes logn.
     * */
}
