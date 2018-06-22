
public class ZigZag {
    /*
    math.
    row = 0 .. nums - 1
    take i = 0, next = (num - row - 1) * 2, next = + row * 2 - 1, dont add if < 0. then do this till out of bounds.
    increase i, row, do the same thing.
    till i == num - 1
    
    */
    public String convert(String s, int numRows) {
        if(s.length() <= numRows || numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            sb.append(s.charAt(i));
            int next = i;
            while(next < s.length()) {
                next += (numRows - i - 1) * 2;
                if((numRows - i - 1) * 2 > 0 && next < s.length()) {
                    sb.append(s.charAt(next));
                }
                next += i * 2;
                if(i * 2 > 0 && next < s.length()) {
                    sb.append(s.charAt(next));
                }
                // System.out.println(sb);
            }
        }
        return sb.toString();
    }
}
