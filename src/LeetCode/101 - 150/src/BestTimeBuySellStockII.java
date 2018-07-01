
public class BestTimeBuySellStockII {
    /* keep adding the incresing pairs
    i to length - 1, if i + 1 > i, then add the diff
	*/
	public int maxProfit(int[] prices) {
	    int res = 0;
	    for(int i = 0; i < prices.length - 1; i++) {
	        if(prices[i + 1] > prices[i]) res += prices[i + 1] - prices[i];
	    }
	    return res;
	}
}
