import java.util.Arrays;

public class ThreeSmClosest {
    /*
    Sort the array, have a global min dist. 
    anchor the element one by one, still skip the duplicate ones.
    calculate the target sum, and the sums of the two pointers. if the abs diff is smaller than global best, update the dist.
    if diff == 0 return, cannot do better.
    moving the pointers should be the same. 

    */
    public int threeSumClosest(int[] nums, int target) {
        int best = Integer.MAX_VALUE, res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int local = target - nums[i];
            int ptr1 = i + 1, ptr2 = nums.length - 1;
            while(ptr1 < ptr2) {
                int sum = nums[ptr1] + nums[ptr2] + nums[i], diff = Math.abs(sum - target);
                if(diff < best) {
                    best = diff;
                    res = sum;
                }
                if(nums[ptr1] + nums[ptr2] < local) ptr1++;
                else if(nums[ptr1] + nums[ptr2] > local) ptr2--;
                else return sum;
            }
        }
        return res;
    }
}
