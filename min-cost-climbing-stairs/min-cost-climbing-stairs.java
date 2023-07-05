public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        memoization(0, cost, dp);
        return Math.min(dp[0], dp[1]);
    }

    public int memoization(int source, int[] cost, int[] dp) {
        if (source >= cost.length) return 0;
        if (dp[source] != -1) return dp[source];

        int subResA = memoization(source + 1, cost, dp);
        int subResB = memoization(source + 2, cost, dp);

        return dp[source] = Math.min(subResA, subResB) + cost[source];
    }
}
