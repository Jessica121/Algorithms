import java.util.*;
public class NQueens {
    /*
    go thru row by row, from 0 to end, put if it is okay to put it.
    dont need to check the row, col boolean array to check if the current col is occupied, if not, set.
    dia and antiDia 2 * n length. could use arraies as well, need to calculate the offsets.
    if row == len add the result.
    list, string. 
    char[] 
    for each create a new char array, filled with .s
    */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] col = new boolean[n], dia = new boolean[2 * n - 1]/*i - j -3 ~ 3*/, anti = new boolean[2 * n - 1];/*i + j, 0 ~ 6*/
        solve(0, col, dia, anti, res, new ArrayList<>(), n);
        return res;
    }
    
    private void solve(int row, boolean[] col, boolean[] dia, boolean[] anti, List<List<String>> res, List<String> temp, int n) {
        if(row == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        char[] arr = new char[n];
        Arrays.fill(arr, '.');
        for(int i = 0; i < n; i++) {
        						// should be + n - 1 offset. not 3 as the example used.
            if(!col[i] && !anti[row - i + n - 1] && !dia[row + i]) {
                col[i] = anti[row - i + n - 1] = dia[row + i] = true;
                arr[i] = 'Q';
                temp.add(new String(arr));
                solve(row + 1, col, dia, anti, res, temp, n);
                arr[i] = '.';
                col[i] = anti[row - i + n - 1] = dia[row + i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
    
}
