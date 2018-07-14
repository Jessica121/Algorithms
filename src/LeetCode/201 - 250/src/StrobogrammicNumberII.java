import java.util.*;

public class StrobogrammicNumberII {
    /*
    for even, generate 11, 00, 88, 69, 96 (back track) and expand. append to the front and end of the string passed in the method.
    for odd, generate even : n - 1. and insert in the center 1, 0, 8, or just to init 3 of these string, instead of empty ones, pass on the generating method
    when string length == n add it to the res.
    to assist generating, put the pairs in to an array to iterate thru.
    corner case: 00 not a number. but need it to generate.
    but 0 is a number
    n == 0, return empty res.
    
    Things related to string rep number, is the 0 thing
    */
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0) return res;
        String[] center = {"0", "1", "8"};
        StringBuilder sb = new StringBuilder();
        if(n % 2 == 0) calculate(sb, n, res);
        else {
            for(String cen : center) {
                sb = new StringBuilder(cen);
                calculate(sb, n, res);
            }
        }
        return res;
    }
    
    private void calculate(StringBuilder sb, int n, List<String> res) {
        if(sb.length() == n) {
        	// when length == 1, first char is 0 is good. else check the first is not 0 before adding.
            if(sb.length() == 1 || sb.charAt(0) != '0') res.add(sb.toString());
            return;
        }
        String[] candi = {"11", "69", "88", "96", "00"};
        for(String can : candi) {
            sb.insert(0, can.charAt(0));
            sb.append(can.charAt(1));
            calculate(sb, n, res);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(0);
        }
    }
}
