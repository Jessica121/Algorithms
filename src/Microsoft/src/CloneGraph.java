import java.util.*;
public class CloneGraph {
    /*
	    Use a Queue do BFS.
	    in the queue, offer original value.
	    map: value and node
	    everytime dequeue a node, check its child, link to the map, and if the child not in map, put and offer to the queue
	    if already in map, just need to link map.get(child.val)
	    if has a cycle, the map already have itself, so wont revisit (be put into queue), just need to link 
	    if not connected, cannot clone the other part
	    graph: null pointer, cycle,(linked list too) DFS, BFS, visited.
    */
	
//	O(V) * O(E)
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        // map from original node to new node, so even if the labels aren't unique, 
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> que = new LinkedList<>();
        map.put(node, new UndirectedGraphNode(node.label));
        que.offer(node);
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                UndirectedGraphNode parent = que.poll();
                UndirectedGraphNode clone = map.get(parent.label);
                for(UndirectedGraphNode child : parent.neighbors) {
                    if(!map.containsKey(child)) {
                        map.put(child, new UndirectedGraphNode(child.label));
                        que.offer(child);
                    } 
                    clone.neighbors.add(map.get(child.label));
                }
            }
        }
        return map.get(node);
    }
    

     public static class UndirectedGraphNode {
    	 int label;
         List<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { 
        	 label = x; 
        	 neighbors = new ArrayList<UndirectedGraphNode>(); 
         }
     }
}
