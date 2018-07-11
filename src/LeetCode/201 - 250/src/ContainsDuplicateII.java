import java.util.*;
public class ContainsDuplicateII {
    /*
    hashmap?
    if exist, compare the index i - map.get(i) <= k 
    tricky part is there could be multiple 1s, dont know which index to store is the most appropriate.
    but since the diff requires at most k, then store the most recent one is best.
    so if distant > k, update the map with current index i.
    if not exist, put it.
    
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) <= k) return true;
                else map.put(nums[i], i);
            } else  map.put(nums[i], i);
        }
        return false;
    }
}
