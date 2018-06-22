import java.util.*;
public class ThreeSum {
    /*
    -4 -1 -1 0 1 2 
    sort the array once, then chose the anchor element one by one if the prev not equal to cur one
    then two pointers with the anchor + 1 and the end, if sum larger than target, decrease the larger pointer, else increase the smaller pointer. if equal. add to the result and shrink the equal elements of the same elements.
    continue untill the start meet the end.
    
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
        	// eliminate the equal values.
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int ptr1 = i + 1, ptr2 = nums.length - 1;
            while(ptr1 < ptr2) {
                if(nums[ptr1] + nums[ptr2] > target) ptr2--;
                else if(nums[ptr1] + nums[ptr2] < target) ptr1++;
                else {
                    res.add(Arrays.asList(new Integer[] {nums[i], nums[ptr1++], nums[ptr2--]}));
                    // eliminate the equal values.
                    while(ptr1 < ptr2 && nums[ptr1] == nums[ptr1 - 1]) ptr1++;
                    while(ptr1 < ptr2 && nums[ptr2] == nums[ptr2 + 1]) ptr2--;
                }
            }
        }
        return res;
    }
}
