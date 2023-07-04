class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1); // Initialize dp array with -1
        return helper(n, dp);
    }

    public int helper(int n, int[] dp) {
        if (n == 0) {
            return 1; // There is one path from 0 to 0, i.e., empty string
        }
        if (dp[n] != -1) {
            return dp[n]; // Return the already calculated value (Preorder)
        }

        int oneStep = (n - 1 >= 0) ? helper(n - 1, dp) : 0;
        int twoSteps = (n - 2 >= 0) ? helper(n - 2, dp) : 0;
        dp[n] = oneStep + twoSteps; // Store the answer in DP Table (Postorder)

        return dp[n];
    }
}