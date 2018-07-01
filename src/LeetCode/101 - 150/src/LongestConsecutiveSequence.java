
public class LongestConsecutiveSequence {
    /*
    use a set, pick one, while find the starting 
    from start (save it first) remove it, find the increase seq. until it is not in the set
    calculate the len, update.
    do this while the set is not empty.
    randomly get one element from the set?
    if use for each element, will it modify concurrently?
    
    */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(), visited = new HashSet<>();
        initSet(set, nums);
        int res = 0;
        for(int ele : set) {
            if(!visited.contains(ele)) {
                while(set.contains(ele)) ele--;
                int start = ele + 1;
                while(set.contains(start)) {
                    visited.add(start);
                    start++;
                }
                res = Math.max(res, start - ele - 1);
            }
        }
        return res;
    }
    
    private void initSet(Set<Integer> set, int[] nums) {
        for(int num : nums) set.add(num);
    }
}
