class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < n; i++) {
            // Treat today as a Buying Day
            int newBuy = Math.max(buy, sell - prices[i]);

            // Treat today as a Selling Day
            int newSell = Math.max(sell, buy + prices[i] - fee);

            buy = newBuy;
            sell = newSell;
        }

        return sell;
    }
}