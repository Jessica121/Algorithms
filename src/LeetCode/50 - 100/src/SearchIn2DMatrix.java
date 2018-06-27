
public class SearchIn2DMatrix {
    /*
    sort vertically first and then horizontally
    
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int row = verticalSearch(matrix, target);
        // if row is -1, return false;
        if(row < 0) return false;
        return horizontalSearch(matrix, target, row);
    }
    
    private int verticalSearch(int[][] matrix, int target) {
        int s = 0, e = matrix.length - 1, mid = -1;
        // in-exact search use s < e and return e
        while(s <= e) {
            mid = s + (e - s) / 2;
            if(matrix[mid][0] > target) e = mid - 1;
            else if(matrix[mid][0] < target) s = mid + 1;
            else return mid;
        }
        return e;
    }
    
    private boolean horizontalSearch(int[][] matrix, int target, int row) {
        int s = 0, e = matrix[row].length - 1, mid = -1;
        // exact search equal to the end.
        while(s <= e) {
            mid = s + (e - s) / 2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] > target) e = mid - 1;
            else s = mid + 1;
        }
        return false;
    }
}
