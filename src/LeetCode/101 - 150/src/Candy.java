import java.util.Arrays;

public class Candy {
    /*
    use an 1-D array to track the candies want to give.
    first from left to right. if left is < next, next one get 1 more candy. else reset to 1. also with equal.
    3 2 2 1 4 4
    1 1 1 1 2 1
    this only will not be enough as if the first one is bigger, it has the same number of candy as it right neibor.
    so from right to left:
    3 2 2 1 4 4
    2 1 2 1 1 1
    take both the results: take max of either.
    use 1D only update when the tobe value > current value.
    3 2 2 1 4 4
    2 1 2 1 2 1
    
    */
    public int candy(int[] ratings) {
        int[] num = new int[ratings.length];
        Arrays.fill(num, 1);
        for(int i = 1; i < ratings.length; i++) {
        	// mind it should be add from the previou result, not increase on itself.
            if(ratings[i] > ratings[i - 1]) num[i] = num[i - 1] + 1;
        }
        for(int i = ratings.length - 2; i >= 0; i--) {
        	// this is the same, add from later results and current one.
            if(ratings[i] > ratings[i + 1]) num[i] = Math.max(num[i], num[i + 1] + 1);
        }
        int res = 0;
        for(int n: num) res += n;
        return res;
    }
}
