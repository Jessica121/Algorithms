
public class OneEditDistance {
    /*
    two pointers on two string: if char is not the same, if two strings of the same length: compare substring later than the char not equal, if not, false.
    if not equal, return either s.substring(i) with t.substr(j + 1) or the other way around. if not, false.
    if everything equal till the end, return s.length - t.length abs value is 1.
    */
    public boolean isOneEditDistance(String s, String t) {
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < s.length() && ptr2 < t.length()) {
            if(s.charAt(ptr1) != t.charAt(ptr2)) {
                if(s.length() == t.length()) return s.substring(ptr1 + 1).equals(t.substring(ptr2 + 1));
                else return s.substring(ptr1).equals(t.substring(ptr2 + 1)) || s.substring(ptr1 + 1).equals(t.substring(ptr2));
            }
            ptr1++;
            ptr2++;
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
