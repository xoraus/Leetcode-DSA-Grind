class Solution {
    public int helper(int n , int[] dp){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];

        int prev1 = helper(n - 1, dp);
        int prev2 = helper(n - 2, dp);
        dp[n] = prev1 + prev2;

        return dp[n];
    }
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
}