
public class TrappingRainWater {
    /*
    the water is bounded by the max of its left and right.
    if using two pointers, update the left right max as we go and calculate and advance the smaller one.
    if tie, advance left one
    min of max left and right and calculate the diff
    
    */
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int res = 0, ptr1 = 0, ptr2 = height.length - 1, left = height[ptr1], right = height[ptr2];
        while(ptr1 < ptr2) {
        	// update the max and min first, but dont advance the pointers.
            if(height[ptr1] >= left) left = height[ptr1];
            if(height[ptr2] >= right) right = height[ptr2];
            // if we are doing on the maxes, the res will be zero. (choose the smaller ones)
            if(height[ptr1] <= height[ptr2]) {
                res += Math.min(left, right) - height[ptr1++];
            } else {
                res += Math.min(left, right) - height[ptr2--];
            }
        }
        return res;
    }
}
