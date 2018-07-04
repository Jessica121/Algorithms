import java.util.Arrays;

public class BestTimeToBuyAndSellIV {
    /*
    obviously kth transaction depends on the k - 1th. 
    so  buy k = max (sell k - 1 - price, buy k - 1)
        sell k = max (buy k + price, sell k)
        
    except for the first one, which buy 0 = buy 0 (MIN) or -price
                                    sell 0 = buy 0 + price or sell 0.
    probably need an array for buy, array for sell.
    at last return sell k.
    
    */
    public int maxProfit(int k, int[] prices) {
        if(k <= 0) return 0;
        // some meaning less shortcut.
        if(k > prices.length / 2) {
            int res = 0;
            for(int i = 0; i < prices.length; i++) {
                if(i > 0 && prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
            }
            return res;
        }
        // end of some meaning less short cut.
        int[] buy = new int[k], sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for(int price : prices) {
            for(int i = 0; i < k; i++) {
                buy[i] = Math.max(buy[i], (i == 0 ? 0 : sell[i - 1]) - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k - 1];
    }
}
