
public class ReverseWordsInAString {
    /*
    reverse the whole string once. skip the blank spaces on the head and tail. append to a string builder.
    then use another stringbuilder, reverse string by string: if meet a blank space, use an auxiliaary pointer start from prev index to the begin pointer, append in reverse order. then append an space, and next one is the begin. set the begin be a non-blank char, considering the first char.
    
    */
    public String reverseWords(String s) {
        s = s.trim();
        s = reverse(s);
        int begin = 0, ptr = 0;
        StringBuilder sb = new StringBuilder();
        while(ptr < s.length()) {
            while(ptr < s.length() && s.charAt(ptr) != ' ') ptr++;
            sb.append(reverse(s.substring(begin, ptr)));
            // dont forget to append an empty space.
            if(ptr < s.length()) sb.append(' ');
            while(ptr < s.length() && s.charAt(ptr) == ' ') ptr++;
            begin = ptr;
        }
        return sb.toString();
    }
    
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        int ptr = s.length() - 1;
        while(ptr >= 0) sb.append(s.charAt(ptr--));
        return sb.toString();
    }
    
    /*
    Split by empty spaces. to an array, and build the string from the end.
    
    */
    public String reverseWordsNeater(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i].isEmpty()) continue;
            sb.append(arr[i]);
            if(i != 0) sb.append(' ');
        }
        return sb.toString();
    }
}
