
public class IsPalindrome {
    /*two pointers, pre-process before check.
    skip blank space, is letter to lower cases, compare the chars
    make clarifications to the interviewer, what is valid and what not.
    */
    public boolean isPalindrome(String s) {
        int ptr1 = 0, ptr2 = s.length() - 1;
        while(ptr1 < ptr2) {
            while(ptr1 < ptr2 && !Character.isLetterOrDigit(s.charAt(ptr1))) ptr1++;
            while(ptr1 < ptr2 && !Character.isLetterOrDigit(s.charAt(ptr2))) ptr2--;
            if(ptr1 < ptr2) {
                if(Character.toLowerCase(s.charAt(ptr1)) != Character.toLowerCase(s.charAt(ptr2))) return false;
            }
            ptr1++;
            ptr2--;
        }
        return true;
    }
}
