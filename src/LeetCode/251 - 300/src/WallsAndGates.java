import java.util.*;
public class WallsAndGates {
    /*
    breadth first search on all the gates (0), iterate thru and offer all position with 0 in a queue, could offer int[2] for the position or have a position class.
    then check all its neighbors, if neibor out of bound or less than current + 1, then skip, else put neibor as current + 1 and offer neighbor into queue. actually BFS will have shortest distance. so it neibor is not INF, could change. others means other reach there first and this one will not be the shortest one.
    but i think the original one would still work as well.
    corner case: empty rooms, does not matter
    
    */
    
    /*
         3  -1  0   1
         2  2   1  -1
         1  -1  2  -1
         0  -1  3   4

    */
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> que = new LinkedList<>();
        initQue(rooms, que);
        int[] dir = {-1, 0, 1, 0, -1};
        while(!que.isEmpty()) {
            int[] pos = que.poll();
            for(int i = 0; i < dir.length - 1; i++) {
                int row = pos[0] + dir[i], col = pos[1] + dir[i + 1];
                if(outOfBound(rooms, row, col) || rooms[row][col] <= rooms[pos[0]][pos[1]] + 1) continue;
                rooms[row][col] = rooms[pos[0]][pos[1]] + 1;
                que.offer(new int[]{row, col});
            }
        }
    }
    
    private void initQue(int[][] rooms, Queue<int[]> que) {
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) que.offer(new int[]{i, j});
            }
        }
    }
    
    private boolean outOfBound(int[][] rooms, int i, int j) {
        return i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length;
    }
}
