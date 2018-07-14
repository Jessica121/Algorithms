import java.util.*;

public class StrobogrammaticIII {
	 /*
    use the second method generate from start to end, not just the two ends jesus
    and eliminate the borders from the result.
    odd: add 0, 1, 8 first then track.
    even: add 0, 0; 1, 1; 6, 9; 9, 6; 8, 8
    try each, until string length reached n.
    */
    public int strobogrammaticInRange(String low, String high) {
        int start = low.length(), end = high.length();
        List<String> res = new ArrayList<>();
        // generate this range of numbers.
        for(int i = start; i <= end; i++) res.addAll(add(i));
        int cnt = 0;
        for(String s: res) {
            if(Long.valueOf(s) < Long.valueOf(low) || Long.valueOf(s) > Long.valueOf(high)) cnt++;
        }
        return res.size() - cnt;
    }
    
    private List<String> add(int n) {
        StringBuilder sb = new StringBuilder();
        String[] center = {"0", "1", "8"};
        List<String> res = new ArrayList<>();
        if(n % 2 == 0) add(n, sb, res);
        else {
            for(String str : center) {
                sb = new StringBuilder(str);
                add(n, sb, res);
            }
        }
        return res;
    }
    
    private void add(int n, StringBuilder sb, List<String> res) {
        if(sb.length() == n) {
            if(sb.length() == 1 || sb.charAt(0) != '0') res.add(sb.toString());
            return;
        }
        int[] pair = {0, 0, 1, 1, 8, 8, 6, 9, 9, 6};
        for(int i = 0; i < pair.length; i += 2) {
            sb.insert(0, pair[i]);
            sb.append(pair[i + 1]);
            add(n, sb, res);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
