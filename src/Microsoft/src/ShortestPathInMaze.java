import java.util.*;
public class ShortestPathInMaze {
/*
 * give a matrix, find the shortest path from start to end.
 * 
 * Use a queue, use a map to track node's parent. 
 * mark visited for each level. could be in parent level or child level.
 * when found the end, track to the parent.
 * for simplicity start is (0, 0) and end is the right down corner of the maze.
 * 
 * int 1 means can go, 0 means cannot go.
 * */
	
	public static List<Coordinate> shortestPathInMaze(Coordinate[][] maze) {
		int endRow = maze.length - 1, endCol = maze[0].length - 1;
		Map<Coordinate, Coordinate> childToParent = new HashMap<>();
		Queue<Coordinate> que = new LinkedList<>();
		Coordinate start = maze[0][0];
		if(!start.blocked) {
			que.offer(start);
			start.visited = true;
		}
		// visited can be modified directly on the maze
		int[] dir = {0, -1, 0, 1, 0};
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i = 0; i < size; i++) {
				Coordinate parent = que.poll();
				if(parent.x == endRow && parent.y == endCol) break;
				for(int j = 0; j < dir.length - 1; j++) {
					Coordinate child = new Coordinate(parent.x + dir[j], parent.y + dir[j + 1], false);
					if(!child.outOfBound(maze)) {
						child = maze[parent.x + dir[j]][parent.y + dir[j + 1]];
						if(!child.visited && !child.blocked) {
							que.offer(child);
							child.visited = true;
							childToParent.put(child, parent);
						}
					}
				}
			}
		}
		Coordinate end = maze[endRow][endCol];
		List<Coordinate> path = new ArrayList<>();
		// if no such path exist, will return a null list.
		while(childToParent.containsKey(end)) {
			path.add(0, end);
			end = childToParent.get(end);
		}
		if(path.size() != 0) path.add(0, start);
		return path;
	}
	
	public static class Coordinate {
		int x, y;
		boolean visited, blocked;
		public Coordinate(int x, int y, boolean blocked) {
			this.x = x;
			this.y = y;
			this.blocked = blocked;
			this.visited = false;
		}
		
		public boolean outOfBound(Coordinate[][] matrix) {
			return this.x < 0 || this.y < 0 || this.x >= matrix.length || this.y >= matrix[0].length;
		}
		@Override
		public String toString() {
			return "(" + x + "," + y +")";
		}
	}
	
	public static void main(String[] args) {
		Coordinate[][] maze = new Coordinate[4][4];
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[0].length; j++) maze[i][j] = new Coordinate(i, j, true);
		}
		maze[0][0].blocked = false;
		maze[1][0].blocked = false;
		maze[1][1].blocked = false;
		maze[1][2].blocked = false;
		maze[2][2].blocked = false;
		maze[3][2].blocked = false;
		maze[3][3].blocked = false;
		System.out.println(shortestPathInMaze(maze));
	}

}
