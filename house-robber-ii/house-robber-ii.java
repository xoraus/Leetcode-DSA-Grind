class Solution {
    public int memoization(int[] nums, int startIndex, int endIndex, int[][] dp) {
        if (startIndex == endIndex - 1) return nums[startIndex];
        if (startIndex >= endIndex) return 0;
        
        if (dp[startIndex][endIndex] != -1)
            return dp[startIndex][endIndex];

        int robCurrent = nums[startIndex] + memoization(nums, startIndex + 2, endIndex, dp);
        int skipCurrent = memoization(nums, startIndex + 1, endIndex, dp);

        return dp[startIndex][endIndex] = Math.max(robCurrent, skipCurrent);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        int maxAmount1 = memoization(nums, 0, n - 1, dp);
        int maxAmount2 = memoization(nums, 1, n, dp);

        return Math.max(maxAmount1, maxAmount2);
    }
}
