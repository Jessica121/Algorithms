
public class LargestRectangleInHistogram {
    /*
    for each histogram, expand to its left and right untill meet one shorter than itself.
    calculate the area, update the result.
    
    */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for(int i = 0; i < heights.length; i++) {
            int left = i - 1, right = i + 1;
            while(left >= 0 && heights[left] >= heights[i]) left--;
            while(right < heights.length && heights[right] >= heights[i]) right++;
            int area = (right - left - 1) * heights[i];
            if(area > max) max = area;
        }
        return max;
    }
}
