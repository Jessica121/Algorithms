import java.util.*;
public class ClosestBinaySearchTreeValueII {
    /*
    maintain a max priority queue of size k, value type double, sort on diff of value and target
    if its larger, offer it, if size > k, poll the top, then go left.
    same with smaller. 
    if it equals, return both the left and the right.
    recursively do it. when node == null, return.
    then return everything in the pq.
    logn(log(logn)) ???
    corner case: when half subtree is not checked but the k > things in the result. which means traverse the tree anyways
    and dont care if its a BST or not.
    tree [2,1]
	target 4.142857
	k 2
    */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
    	PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(Math.abs(b - target), Math.abs(a - target)));
        check(root, target, k, pq);
        return putPqInList(pq);
    }
    
    private void check(TreeNode node, double target, int k, PriorityQueue<Double> pq) {
        if(node == null) return;
        pq.offer((double) node.val);
        if(pq.size() > k) pq.poll();
        check(node.right, target, k, pq);
        check(node.left, target, k, pq);
    }

    private List<Integer> putPqInList(PriorityQueue<Double> pq) {
        List<Integer> res = new ArrayList<>();
        for(double elem : pq) {
            res.add((int) elem);
        }
        return res;
    }
}
