
public class BestTimeBuySellStockI {
    /*
    as sell must from buy, so buy the min and sell the max in time order.
    buy = min (buy, cur)
    sell = cur - buy if larget
    
    */
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, sell = 0;
        for(int price : prices) {
            if(price < buy) buy = price;
            else sell = Math.max(sell, price - buy);
        }
        return sell;
    }
}
