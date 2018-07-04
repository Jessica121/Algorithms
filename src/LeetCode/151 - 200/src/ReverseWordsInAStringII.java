
public class ReverseWordsInAStringII {
    /*
    reverse the whole thing first, nice thing we dont need to worry about those blank spaces, just tedious not complex.
    then reverse partial base on ptr1, ptr2. 
    after reversing, ptr1 = ptr2 + 1, assuming we stop when ptr2 is a '.'
    after reverse, skip the blank space as above: the last one need to reversed as well. could put i into s.length(). and check if is a dot or out of bound.
    
    */
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int ptr1 = 0, ptr2 = 0;
        while(ptr2 <= str.length) {
            while(ptr2 < str.length && str[ptr2] != ' ') ptr2++;
            reverse(str, ptr1, ptr2 - 1);
            ptr1 = ptr2 + 1;
            ptr2++;
        }
    }
    
    private void reverse(char[] str, int start, int end) {
        while(start < end) {
            char temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }
}
