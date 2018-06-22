
public class Strstr {
    /*
    sliding window, check substring equals, from i = 0 .. hay.length - needle.length inclusive
    if equal, return i
    works on empty string as well.
    */
    public int strStr(String haystack, String needle) {
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(haystack.substring(i, i + needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}
