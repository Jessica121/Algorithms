import java.util.*;
public class EncodeAndDecodeStrings {

    /*
    to compress a string, needs to know the length splitter and the original string.
    realy nothing about building a tree, or have to be balanced.
    compress the information that helps retriving the string along with the compressed string.
    
    */
    
    /*
    compress the string: append the length of string, a splitter that both encode and decode knows, and the original string to extract.
    append length, splitter (a global constant), and original string.
    
    */
    
    public static final char SPLITR = '.';
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) sb.append(str.length()).append(SPLITR).append(str);
        return sb.toString();
    }

    /*
    to decode, use two pointers deal with the string.
    first pointer anchors the starting index, second one runs (while inbound and != SPLTR) until it meets SPLITR. 
    extract the substring made by ptr1 and ptr2, get the value of int. and take substring(ptr2 + 1, ptr2 + 1 + len.) put into res.
    reset ptr1 as ptr2 + 1 + len, ptr2 equals ptr1.
    the condition will be ptr2 in bound.
    
    */
    public List<String> decode(String s) {
        int ptr1 = 0, ptr2 = 0;
        List<String> res = new ArrayList<>();
        while(ptr2 < s.length()) {
            while(ptr2 < s.length() && s.charAt(ptr2) != SPLITR) ptr2++;
            if(ptr2 < s.length()) {
                int len = Integer.valueOf(s.substring(ptr1, ptr2));
                res.add(s.substring(ptr2 + 1, ptr2 + 1 + len));
                ptr1 = ptr2 = ptr2 + 1 + len;
            }
        }
        return res;
    }
}
