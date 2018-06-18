import java.util.*;
public class WallsAndGates {
	/*
    Multi-end BFS, iterate all the cells, put 0s into queue.
    do a BFS that, if neighbor > 0, and cur + 1 < nei val. update nei value add it to the queue.
    else dont add it.
    till the queue is empty.
    
    */
    public void wallsAndGatesBFS(int[][] rooms) {
        Queue<Cell> que = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) que.offer(new Cell(i, j));
            }
        }
        int[] dir = {0, -1, 0, 1, 0};
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Cell cell = que.poll();
                for(int j = 0; j < dir.length - 1; j++) {
                    int row = cell.row + dir[j], col = cell.col + dir[j + 1];
                    if(!outOfBounds(row, col, rooms) && rooms[row][col] > 0) {
                        if(rooms[row][col] > rooms[cell.row][cell.col] + 1) {
                            que.offer(new Cell(row, col));
                            rooms[row][col] = rooms[cell.row][cell.col] + 1;
                        }
                    }  
                }
            }
        }
    }
    
    private boolean outOfBounds(int row, int col, int[][] rooms) {
        return row < 0 || col < 0 || row >= rooms.length || col >= rooms[0].length;
    }
    
    class Cell {
        int row, col;
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    /*
	    DFS will be when the current cell is > 0 and the value it is going to be set is less than cur value.
	    if the current value == 0, then do DFS without setting its value.
	    if so, set the value and continue to do DFS.
	    for the neibors, pass the value neibors should be set, the current value + 1.
	    start with values with 0.
	*/
	public void wallsAndGatesDFS(int[][] rooms) {
	    for(int i = 0; i < rooms.length; i++) {
	        for(int j = 0; j < rooms[0].length; j++) {
	            if(rooms[i][j] == 0) dfs(rooms, i, j, 0);
	        }
	    }
	}
	
	private void dfs(int[][] rooms, int i, int j, int val) {
	    if(i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] < val) return;
	    rooms[i][j] = val;
	    dfs(rooms, i - 1, j, rooms[i][j] + 1);
	    dfs(rooms, i, j - 1, rooms[i][j] + 1);
	    dfs(rooms, i + 1, j, rooms[i][j] + 1);
	    dfs(rooms, i, j + 1, rooms[i][j] + 1);
	}
}
