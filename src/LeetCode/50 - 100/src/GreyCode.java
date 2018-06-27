import java.util.*;

public class GreyCode {
	/* previous result, reverse add 1. */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if(n == 0) return res;
        res.add(1);
        if(n == 1) return res;
        List<Integer> next = grayCode(n - 1);
        int mask = 1 << (n - 1);
        int size = next.size();
        for(int i = size - 1; i >= 0; i--) {
            next.add(next.get(i) | mask);
        }
        return next;
    }
}
