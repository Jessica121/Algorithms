
public class TwoSum {
	/*
    array sum question: use a map to check on the fly if the other half already exsit in the map.
    if so, return the map.get and current, else, put the current and index in the map.
    if two elements are the same. its okay to override, since the sum is made up by two.
    */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) return new int[] {map.get(target - nums[i]), i};
            else map.put(nums[i], i);
        }
        return null;
    }
}
