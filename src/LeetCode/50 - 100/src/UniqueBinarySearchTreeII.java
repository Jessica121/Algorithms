import java.util.*;
public class UniqueBinarySearchTreeII {
    /*
    i ranges from 1 to n, left list, concat with right list. add to result.
    have a map of node.val and its trees root as itself.
    create a new treenode and copy and add
    
    */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if(n == 0) return list;
        Map<String, List<TreeNode>> map = new HashMap<>();
        return generate(1, n, map);
    }
    
    private List<TreeNode> generate(int start, int end, Map<String, List<TreeNode>> map) {
        if(start > end) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        String key = new String(start + ", " + end);
        if(map.containsKey(key)) return map.get(key);
        for(int i = start; i <= end; i++) {
            List<TreeNode> left = generate(start, i - 1, map), right = generate(i + 1, end, map);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    map.computeIfAbsent(key, k -> new ArrayList<>()).add(node);
                }
            }
        }
        return map.get(key);
    }
}
