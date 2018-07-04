import java.util.Arrays;

public class NumberOfIslands {
    /*
    first attempt is to use union find. can convert 2D array to 1D to get the island array.
    the problem is how to count the parents :] 
    if its parent is not itself, add one island.
    then for all its neibors that are 1, set their parent to itself's parent, if not the same parent. so wont go back.
    set parent: if p1 != p2, island[p2] = p1. (neibor is self. not the other way around.)
    calculate index: row * grid[0].length + col.
    */
    public int numIslandsUnionFind(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int[] parent = new int[grid.length * grid[0].length];
        Arrays.fill(parent, -1);
        int cnt = 0;
        int[] dir = {-1, 0, 1, 0, -1};
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    int selfIndex = i * grid[0].length + j;
                    int p1 = find(selfIndex, parent);
                    for(int k = 0; k < dir.length - 1; k++) {
                        int row = i + dir[k], col = j + dir[k + 1];
                        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
                            int neiIndex = row * grid[0].length + col;
                            int p2 = find(neiIndex, parent);
                            if(p1 != p2) parent[p2] = p1;
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    int selfIndex = i * grid[0].length + j;
                    int p1 = find(selfIndex, parent);
                    if(p1 == selfIndex) cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    private int find(int index, int[] parent) {
        while(parent[index] != -1) index = parent[index];
        return index;
    }
    
    
    /*
    DFS, if not out of bounds and not visited and is 1, visit.
    add the number that is not visited.
    
    */
    public int numIslandsDFS(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int cnt = 0;
         for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    mark(grid, i, j, visited);
                }
            }
         }
        return cnt;
    }
    
    private void mark(char[][] grid, int i, int j, boolean[][] visited) {
    	// Cannot be 0, cannot be visited.
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1' || visited[i][j]) return;
        // MARK VISITED OMG. 
        visited[i][j] = true;
        mark(grid, i - 1, j, visited);
        mark(grid, i + 1, j, visited);
        mark(grid, i, j - 1, visited);
        mark(grid, i, j + 1, visited);
    }
}
