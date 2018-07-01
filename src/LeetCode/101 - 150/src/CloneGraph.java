import java.util.*;

public class CloneGraph {
    /*
    clone's node's neibor = clone node
    use a map of original node to cloned node:
    seems like the graph is sure to be connected. since only one node is given as the input.
    even if its not, can clone all original nodes first into map.
    DFS: eveytime clone self if not in map yet.
    for each node's child, only when map does not contain the node, recursively clone, and link clone node to children node in the map.
    for a cycle: node wont be recursively called if node is already in the map.
    
    */
	
	// O(V * E)
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        clone(node, map);
        return map.get(node);
    }
    
    private void clone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if(node == null) return;
        map.put(node, new UndirectedGraphNode(node.label));
        for(UndirectedGraphNode neighbor : node.neighbors) {
            if(!map.containsKey(neighbor)) clone(neighbor, map);
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
    
    private static class UndirectedGraphNode {
    	int label;
    	List<UndirectedGraphNode> neighbors;
    	UndirectedGraphNode(int x) { 
    		label = x; 
    		neighbors = new ArrayList<UndirectedGraphNode>(); 
    	}
    };
}
