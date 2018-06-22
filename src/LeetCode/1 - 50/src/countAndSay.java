
public class countAndSay {
    /*
    i = 1; everytime generate one i++, till it reached the n
    prev char = '1', cnt = 0
    String to be replaced by each iteration: 
    String = "1" initially.
    for each char, if equal prev, cnt++, else put cnt and prev into sb, reset cnt = 1, prev = this.
    out of the loop check again.
    set the temp str to the string to be checked next time.
    increase the i
    
    */
    public String countAndSay(int n) {
        String str = "1";
        char prev = str.charAt(0);
        int cnt = 0;
        for(int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == prev) cnt++;
                else {
                    sb.append(cnt).append(prev);
                    prev = str.charAt(j);
                    cnt = 1;
                }
            }
            sb.append(cnt).append(prev);
            str = sb.toString();
            // reset the prev and cnt into the first char and 0, respectiely
            prev = str.charAt(0);
            cnt = 0;
        }
        return str;
    }
}
