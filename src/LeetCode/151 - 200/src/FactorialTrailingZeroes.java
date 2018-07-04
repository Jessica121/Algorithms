
public class FactorialTrailingZeroes {
    /*
    i think that the number of 5 <= number of 2.
    and that makes a 0. so track the number of 5 along with its multiples: 10, 15, 25.
    
    */
    public int trailingZeroes(int n) {
        int numOf5 = 0;
        for(int i = 1; i <= n; i++) {
            if(i % 5 == 0) numOf5 += cntFive(i);
        }
        return numOf5;
    }
    
    private int cntFive(int n) {
        int i = 0;
        // mind that the condition should be n % 5 == 0, not n > 0.
        while(n % 5 == 0) {
            n /= 5;
            i++;
        }
        return i;
    }
    
    /*
    the idea is how many 5 it got. then how many 25: meaning how many extra 5s. then 5^3 = 125, how many extra 5s.
    could be both iteratively and recursively.
    recursion: how many n / 5 + recurse(n / 5) essentially multiply by 5.
    
    */
    public int trailingZeroesRecursion(int n) {
        if(n == 0) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }
    
    public int trailingZeroesInterative(int n) {
        int res = 0;
        // this div might overflow.
        long div = 5;
        while(n / div > 0) {
            res += n / div;
            div *= 5;
        }
        return res;
    }
}
