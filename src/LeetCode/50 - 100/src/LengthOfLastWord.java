
public class LengthOfLastWord {
    /*
    if meets a blank space, reset the start pointer.
    return two pointers length.
    if ptr1 > ptr2, 0
    ptr2 is the length of string - 1
    */
    public int lengthOfLastWord(String s) {
        int ptr = 0, len = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
            	// could be multiple blank space, it should not update.
                if(i != ptr) len = i - ptr;
                ptr = i + 1;
            }
        }
        if(ptr != s.length()) len = s.length() - ptr;
        return len;
    }
}
