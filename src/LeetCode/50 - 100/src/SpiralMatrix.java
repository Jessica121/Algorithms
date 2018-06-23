import java.util.*;
public class SpiralMatrix {
    /*
    top, down, left, right.
    top left to right, top--
    right top to down, right--
    down right to left, down++
    left down to top, left++
    
    if one of the condition does not meet, break
    
    */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        int top = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while(top <= down && left <= right) {
            if(top <= down) {
                for(int i = left; i <= right; i++) res.add(matrix[top][i]);
                // top++ not --
                top++;
            }
            if(left <= right) {
                for(int i = top; i <= down; i++) res.add(matrix[i][right]);
                right--;
            }
            // check top down when doing left right 
            if(top <= down) {
            	// right to left is >= not <=
                for(int i = right; i >= left; i--) res.add(matrix[down][i]);
                down--;
            }
            if(left <= right) {
                for(int i = down; i >= top; i--) res.add(matrix[i][left]);
                left++;
            }
        }
        return res;
    }
}
