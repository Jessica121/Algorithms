import java.util.*;
public class ContainsDuplicate {
    /*
    use a set to track?
    sort?
    bucket sort?
    */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(!set.add(num)) return true;
        }
        return false;
    }
}
