
public class Triangle {
    /*
    backtracking. min of left and right. next level, index. index and index + 1.
    if level == triangle.size(), return 0.
    
    */
    public int minimumTotal(List<List<Integer>> triangle) {
    	// memo check dup prune tree.
    	// DFS think if can use memo to optimize the search process.
        Map<String, Integer> map = new HashMap<>();
        return min(triangle, 0, 0, map);
    }
    
    private int min(List<List<Integer>> triangle, int level, int index, Map<String, Integer> map) {
        if(level == triangle.size()) return 0;
        String key = new String(level + ", " + index);
        if(map.containsKey(key)) return map.get(key);
        int res = triangle.get(level).get(index) + Math.min(min(triangle, level + 1, index, map), min(triangle, level + 1, index + 1, map));
        map.put(key, res);
        return res;
    }
}
