
public class ContainerWithTheMostWater {
    /*
    two pointers set at two ends, advance the shorter one.
    if same, advance left one.
    if same left one next shorter or higher both wont be better than two same ones.
    until left and right is met.
    */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if(height[left] <= height[right]) left++;
            else right--;
        }
        return max;
    }
}
