import java.util.*;
public class SurroundedRegions {
    /*
    union find
    second pass find, if its an O and its parent not belongs to the border, flip it.
    but how to rep when parents not on the border.
    if the nei is on the border, first connect it, then add the parent to a set indicating it is a border parent.
    the set may end up being having more intermediate parent than necessary, but its fine cuz we wont keep them in the final result. 
    second pass, for each 'O', find its parents, see if its in the set or not. if not. set to 'X'
    use a 1-D array to serve as islands to find parents. row * width + col is the index.
    fill the array with -1.
    */
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int[] parents = new int[board.length * board[0].length];
        Arrays.fill(parents, -1);
        Set<Integer> set = new HashSet<>(); // set to track parents when on border.
        int[] dir = {-1, 0, 1, 0, -1};
        for(int i = 1; i < board.length - 1; i++) {
            for(int j = 1; j < board[0].length - 1; j++) {
                if(board[i][j] == 'O') {
                    int p1 = find(i * board[0].length + j, parents);
                    for(int k = 0; k < dir.length - 1; k++) {
                        int row = i + dir[k], col = j + dir[k + 1];
                        if(board[row][col] == 'O') {
                            int p2 = find(row * board[0].length + col, parents);
                            // should set neibor is self.
                            // mind have to have: p1 != p2. since current may be last time's neibor. its neibor is last time's
                            if(p1 != p2) parents[p2] = p1;
                            // set.contains(p2) is essential: since center cells, their neibor not at the border, however, it may
                            // connect to them. so if neibor is in the set, add itself in the set too. set is region parents.
                            if(row == 0 || col == 0 || row == board.length - 1 || col == board[0].length - 1 || set.contains(p2)) {
                                set.add(p1);
                            }
                        }
                    }
                }
            }
        }
        for(int i = 1; i < board.length - 1; i++) {
            for(int j = 1; j < board[0].length - 1; j++) {
                if(board[i][j] == 'O') {
                    if(!set.contains(find(i * board[0].length + j, parents))) board[i][j] = 'X';
                }
            }
        }
    }
    
    private int find(int index, int[] parents) {
        while(parents[index] != -1) index = parents[index];
        return index;
    }
}
