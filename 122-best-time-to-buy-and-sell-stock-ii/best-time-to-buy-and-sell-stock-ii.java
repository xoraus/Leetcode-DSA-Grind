class Solution {
    public int maxProfit(int[] prices) {
        int buyingPrice = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buyingPrice < prices[i]) {
                profit += prices[i] - buyingPrice;
            }
            buyingPrice = prices[i];
        }

        return profit;
    }
}
