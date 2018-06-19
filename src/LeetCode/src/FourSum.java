import java.util.*;

public class FourSum {
    /*
    Sort the array, anchor first, then do three sum on the rest. target -= first element.
    O(N^3)
    
    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int first = target - nums[i];
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j - 1] == nums[j]) continue;
                int second = first - nums[j];
                int ptr1 = j + 1, ptr2 = nums.length - 1;
                while(ptr1 < ptr2) {
                    int sum = nums[ptr1] + nums[ptr2];
                    if(sum == second) {
                        res.add(Arrays.asList(new Integer[] {nums[i], nums[j], nums[ptr1++], nums[ptr2--]}));
                        while(ptr1 < ptr2 && nums[ptr1] == nums[ptr1 - 1]) ptr1++;
                        while(ptr1 < ptr2 && nums[ptr2] == nums[ptr2 + 1]) ptr2--;
                    } else if(sum > second) ptr2--;
                    else ptr1++;
                }
            }
        }
        return res;
    }
}
