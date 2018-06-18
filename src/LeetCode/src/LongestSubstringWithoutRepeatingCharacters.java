
public class LongestSubstringWithoutRepeatingCharacters {
    /*
    two pointers, use an array to check the number of chars meet from ptr2, update the length as long as array[ptr2.char] == 0
    increase it.
    if already 1, increase it and stop.
    advance the first pointer
    while ptr1 < ptr2, decrease the cnt untill meet a cnt == 2; decrease it, advance it and stop.
    do the same thing.
    this works when the whole string is unique.
    */
    public int lengthOfLongestSubstring(String s) {
        int res = 0, ptr1 = 0, ptr2 = 0;
        int[] arr = new int[128]; // assume ASCII
        while(ptr2 < s.length()) {
            arr[s.charAt(ptr2)] += 1;
            if(arr[s.charAt(ptr2)] == 1) {
            	// check result as long as valid.
                res = Math.max(res, ptr2 - ptr1 + 1);
            } else if(arr[s.charAt(ptr2)] == 2) {
                while(ptr1 < ptr2 && arr[s.charAt(ptr1)] <= 2) {
                    arr[s.charAt(ptr1)]--;
                    ptr1++;
                    // decrease while the char is uniq.
                    if(arr[s.charAt(ptr2)] == 1) break;
                }
            }
            ptr2++;
        }
        return res;
    }
}
