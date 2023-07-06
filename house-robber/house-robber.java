class Solution {
    public int memoization(int[] nums, int currIdx, int prevChoice, int[][] dp) {
        if (currIdx == nums.length)
            return 0;
        if (dp[currIdx][prevChoice] != -1)
            return dp[currIdx][prevChoice];

        int robCurrent = (prevChoice == 0) ? (memoization(nums, currIdx + 1, 1, dp) + nums[currIdx]) : 0;
        int skipCurrent = memoization(nums, currIdx + 1, 0, dp);

        return dp[currIdx][prevChoice] = Math.max(robCurrent, skipCurrent);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return memoization(nums, 0, 0, dp);
    }
}
