
public class LongestCommonSubstring {
    /*
    first longest common prefix is the first string.
    then the second compare to prefix, two pointers, break when not equal, take the substring as the prefix.
    do it to the rest of the strings.
    if(prefix == empty) break and return.
    
    */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            prefix = commonPrefix(prefix, cur);
            if(prefix.isEmpty()) return prefix;
        }
        return prefix;
    }
    
    private String commonPrefix(String p, String cur) {
        int ptr = 0;
        while(ptr < Math.min(p.length(), cur.length())) {
            if(p.charAt(ptr) != cur.charAt(ptr)) break;
            ptr++;
        } 
        return p.substring(0, ptr);
    }
}
