
public class WordSearch {
    /*
    first sight would be BFS but it wouldnt work when multiple neibors of the parents consist of the word.
    so should use dfs.
    everytime meet a start, use bfs. pass on the word, the index.
    
    */
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(dfs(0, i, j, board, word, visited)) return true;
                }
            }
        }
        return false;
    }
    // backtracking really is a DFS
    private boolean dfs(int index, int row, int col, char[][] board, String word, boolean[][] visited) {
    	// first check index reach the end of string or not, if return true. since it might be when the row col out of bounds.
        if(index == word.length()) return true;
        // then, please, for dfs, or bfs, before using its neigbor, 
        // checking out of bounds is good, but also please check the visited as well. or when to check visited when only remebered to set it ?
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) return false;
        visited[row][col] = true;
        if(board[row][col] == word.charAt(index)) {
        	// also, not return four of its neibors, since which appeared first might affect results, so like backtrack its neibors.
            /* perfect example:
             * [["A","B","C","E"]
             * ,["S","F","E","S"]
             * ,["A","D","E","E"]]
             * 
             * "ABCESEEEFS"
             * */
        	
        	if(dfs(index + 1, row + 1, col, board, word, visited) || dfs(index + 1, row - 1, col, board, word, visited) 
               || dfs(index + 1, row, col + 1, board, word, visited) || dfs(index + 1, row, col - 1, board, word, visited))
                return true;
        }
        // unvisit the cell.
        visited[row][col] = false;
        return false;
    }
}
