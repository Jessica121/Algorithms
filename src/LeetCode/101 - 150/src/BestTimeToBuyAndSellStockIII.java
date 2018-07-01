
public class BestTimeToBuyAndSellStockIII {
    /*
    buy1 = MIN, buy1 = -p
    sell1 = 0, sell1 = buy1 + p
    buy2 = MIN, buy2 = sell1 - p
    sell2 = 0, sell2 = buy2 + p
    take the max of sell2
    */
    public int maxProfit(int[] prices) {
        int b1 = Integer.MIN_VALUE, s1 = 0, b2 = Integer.MIN_VALUE, s2 = 0;
        for(int price : prices) {
            b1 = Math.max(b1, -price);
            s1 = Math.max(s1, b1 + price);
            b2 = Math.max(b2, s1 - price);
            s2 = Math.max(s2, b2 + price);
        }
        return s2;
    }
}
