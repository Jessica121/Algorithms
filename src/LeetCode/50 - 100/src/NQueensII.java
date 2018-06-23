import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII {
    /*
    really the same as the prvious one,if reach the end, increase the result
    
    */
    
    private int res = 0;
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n], dia = new boolean[2 * n - 1]/*i - j -3 ~ 3*/, anti = new boolean[2 * n - 1];/*i + j, 0 ~ 6*/
        solve(0, col, dia, anti, new ArrayList<>(), n);
        return res;
    }
    
    private void solve(int row, boolean[] col, boolean[] dia, boolean[] anti, List<String> temp, int n) {
        if(row == n) {
            res++;
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
                solve(row + 1, col, dia, anti, temp, n);
                arr[i] = '.';
                col[i] = anti[row - i + n - 1] = dia[row + i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
