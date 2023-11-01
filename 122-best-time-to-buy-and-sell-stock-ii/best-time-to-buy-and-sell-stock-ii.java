class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (!stack.isEmpty() && stack.peek() < prices[i]) {
                profit += prices[i] - stack.pop();
            }
            stack.push(prices[i]);
        }

        return profit;
    }
}
