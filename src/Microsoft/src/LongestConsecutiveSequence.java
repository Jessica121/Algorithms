import java.util.*;
public class LongestConsecutiveSequence {
	/*
	 * N LOG N treeset
    Put into treeset, start with the smallest element, if prev = null, prev = curr, cnt++,
    else if cur = prev + 1, cnt++
    else cur = prev, update the cnt.
    out of the loop, update the cnt into res as well.
    nlogn
    
    */
  
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int n : nums) set.add(n);
        int res = 0, cnt = 0;
        Integer prev = null;
        for(int cur : set) {
            if(prev == null || prev + 1 == cur) {
                cnt++;
            } else {
                if(cnt > res) res = cnt;
                cnt = 1;
            }
            prev = cur;
        }
        if(cnt > res) res = cnt;
        return res;
    }
    
    /*
    O(N) set manipulation.
    put into set, iterate thru the array. while it is contained in the set, while check cur - 1. and check upwareds by 1, update the cnter, remove each reached element from the set.
    so if the element not contained in the set, pass.
    O(2*N) worst case. O(N)
    
    */
    public int longestConsecutiveTwo(int[] nums) {
        Set<Integer> set = new HashSet<>();
        putInSet(set, nums);
        int res = 0, cnt = 0;
        for(int num : nums) {
            if(set.contains(num)) {
                while(set.contains(num - 1)) num -= 1;
                while(set.contains(num)) {
                    set.remove(num);
                    num += 1;
                    cnt++;
                }
                if(cnt > res) res = cnt;
                cnt = 0;
            }
        }
        return res;
    }
    
    private void putInSet(Set<Integer> set, int[] nums) {
        for(int n : nums) set.add(n);
    }
}
