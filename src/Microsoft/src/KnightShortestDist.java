
public class KnightShortestDist {
/*
 * Given a chess board, a start and an end, find the shortest path, a knight goes from start to end.
 * find all paths: add up each of children which has results. use a map to memo current cell's path number.
 * backtrack: change the start to the new start.
 * matrix manipulation: graph, each cell is a node, mark visited.
 * 
 * recursion returns the min result from all 8 neighbors
 * for all its 8 neighbors, set the neibor as the start in the next resursion call, add it to the visited matrix or set.
 * then undo it, next neibor.
 * if the row and col out of bounds return 0;
 * if the start == end return 1;
 * if(child recursive call != 0) res += child res (not add 1)
 * 
 * record visited when find in a defined direction.
 * 
 * matrix recursion: base case: if row and col out of bounds OR the row and col has been visited.
 * else set the current one (the parent) as visited, and recurse on the children.
 * */
	
	public static int minWays(int[][] matrix, int sR, int sC, int eR, int eC) {
		return find(matrix, sR, sC, eR, eC, new boolean[matrix.length][matrix[0].length]);
	}
	
	// Super inefficient DFS
	// BFS with a queue will be better..
	private static int find(int[][] matrix, int sR, int sC, int eR, int eC, boolean[][] visited) {
		// matrix find / backtrack check if unvisited in parent level or child level.
		// if visited, stop.
		if(outOfBounds(sR, sC, matrix) || visited[sR][sC]) return Integer.MAX_VALUE;
		if(sR == eR && sC == eC) return 0;
		int[] dir = {-2, 1, 2, 1, -2, -1, 2, -1, -2};
		int min = Integer.MAX_VALUE;
		// mark the parent visited here.
		// save the trouble of bound check for children if want to set it visited.
		visited[sR][sC] = true;
		for(int i = 0; i < dir.length - 1; i++) {
			int startRow = sR + dir[i], startCol = sC + dir[i + 1];
			int next = find(matrix, startRow, startCol, eR, eC, visited);
			// have to check next is max value, if want to add it by 1. else will become negative.
			if(next != Integer.MAX_VALUE) min = Math.min(min, next + 1);
		}
		// unvisited self.
		visited[sR][sC] = false;
		return min;
	}
	
	private static boolean outOfBounds(int row, int col, int[][] matrix) {
		return row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 0, 1, 0, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 1},
				{1, 0, 1, 0, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 1},
				{1, 0, 1, 0, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 1},
				{1, 0, 1, 0, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 1}	
		};
		System.out.println(minWays(matrix, 0, 0, 2, 1));
	}

}
