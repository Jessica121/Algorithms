import java.util.*;
public class SimplfyPath {
    /*
    /../ means go back
    use a stack, only push to the back if everything in between / / is not a ., not .., not "" 
    if ".." pop the stack if not empty.
    two pointers check the substring
    
    */
    public String simplifyPath(String path) {
        Stack<String> sta = new Stack<>();
        int i = 0, j = 0;
        while(i < path.length()) {
            if(path.charAt(i) == '/') {
                j = i + 1;
                while(j < path.length() && path.charAt(j) != '/') j++;
                String addr = path.substring(i, j);
                if(addr.equals("/..") && !sta.isEmpty()) sta.pop(); 
                else if(!addr.equals("/") && !addr.equals("/.") && !addr.equals("/..")) sta.push(addr);
            }
            if(j == i) break;
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while(!sta.isEmpty()) sb.insert(0, sta.pop());
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
