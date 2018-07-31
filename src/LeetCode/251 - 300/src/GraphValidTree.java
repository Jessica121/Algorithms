import java.util.Arrays;

public class GraphValidTree {
    /*
    this could not be done by topological sort as topological sort is meant for directed edges, since it is for building dependencies :]..
    since a tree means every node have one parent, can use union find.
    when there is a cycle means the node has already linked thru other path. so thats a no.
    and also may have more roots, so check again if only one has the -1 as the value in the parent island.
    init a parent island array with -1.
    for each egde, find both ends parent and assign p1's parent as p0's parent, if they are not the same, else return false.
    then run again check only one root is present.
    
    */
    public boolean validTree(int n, int[][] edges) {
        int[] island = new int[n];
        Arrays.fill(island, -1);
        for(int[] edge : edges) {
            int p1 = find(edge[0], island), p2 = find(edge[1], island);
            if(p1 == p2) return false;
            island[p2] = p1;
        }
        boolean hasFoundRoot = false;
        for(int is : island) {
            if(is == -1) {
                if(hasFoundRoot) return false;
                hasFoundRoot = true;
            }
        }
        return true;
    }
    
    private int find(int child, int[] island) {
        while(island[child] != -1) {
            child = island[child];
        }
        return child;
    }
}
