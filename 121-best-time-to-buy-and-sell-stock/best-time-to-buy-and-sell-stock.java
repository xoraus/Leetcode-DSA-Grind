class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int selling = 0, profit = 0;
        int buying = prices[n - 1]; // Initialize buying with the last day's price

        for (int i = n - 1; i >= 0; i--) {
            selling = Math.max(selling, prices[i]); // Update the maximum selling price
            buying = prices[i]; // Update: Today as Potential Buying Day
            profit = Math.max(profit, selling - buying); // Calculate and update the maximum profit
        }

        return profit;
    }
}
