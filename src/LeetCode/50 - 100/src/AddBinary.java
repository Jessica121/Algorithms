
public class AddBinary {
    /*
    ^ two digits ^ the flag;
    if number of 1 >= 2, flag = 1
    reverse the string.
    */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ptr1 = a.length() - 1, ptr2 = b.length() - 1, cnt = 0, flag = 0;
        while(ptr1 >= 0 || ptr2 >= 0) {
            int d1 = ptr1 >= 0 ? a.charAt(ptr1--) - '0' : 0, d2 = ptr2 >= 0 ? b.charAt(ptr2--) - '0' : 0;
            cnt = d1 + d2 + flag;
            // the below code is just ugly and silly.
//            if(d1 == 1) cnt++;
//            if(d2 == 1) cnt++;
//            if(flag == 1) cnt++;
            int d = d1 ^ d2 ^ flag;
            flag = cnt >= 2 ? 1 : 0;
            sb.append(d);
            cnt = 0;
        }
        if(flag == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
