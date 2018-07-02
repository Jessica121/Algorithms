
public class LongestSubstringWithAtMost2DistinctCharacters {
    /*
    two pointers no brainer.
    use a cnter track distinct: when it is not in the map. for the ptr2. if exist, add, if not, add and increase the cnter.
    when cnt == 3. shrink the first pointer. decrease the value in the map
    cnt -- only when map value becomes 0.
    update the length when cnt == 2.
    update length differentiate from shrinking the ptr1.
    
    */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ptr1 = 0, ptr2 = 0, cnt = 0, res = 0;
        int[] map = new int[128]; // assume ASCII, 0 means increase cnter.
        while(ptr2 < s.length()) {
            if(map[s.charAt(ptr2)] == 0) cnt++;
            map[s.charAt(ptr2)]++;
            while(cnt > 2) {
                if(ptr1 < ptr2) {
                    map[s.charAt(ptr1)]--;
                    if(map[s.charAt(ptr1)] == 0) cnt--;
                    ptr1++;
                }
            }
            // since it is at most two, so update when <= 2
            if(cnt <= 2) res = Math.max(res, ptr2 - ptr1 + 1);
            ptr2++;
        }
        return res;
    }
}
