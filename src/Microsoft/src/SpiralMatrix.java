import java.util.*;
public class SpiralMatrix {
    /*
    T  [ 1, 2, 3 ],
       [ 4, 5, 6 ],
    B  [ 7, 8, 9 ]
         L     R
         
     from top: left <= right, top++
     then from top(new) <= bottom, right--
     then bottom: from left <= new right, bottom++
     then left: from new top <= new bottom, left++
 
 */
 public List<Integer> spiralOrder(int[][] matrix) {
     List<Integer> res = new ArrayList<>();
     if(matrix.length == 0) return res;
     int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
     while(top <= bottom && left <= right) {
         if(top <= bottom) {
             for(int i = left; i <= right; i++) res.add(matrix[top][i]);
             top++;
         }
         if(left <= right) {
             for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
             right--;
         }
         // if top > bottom, right edge wont be printed, but the right to left will be printed again. when it is not a square.
         if(top <= bottom) {
             for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
             bottom--;
         }
         if(left <= right) {
             for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
             left++;
         }
     }
     return res;
 }
}
