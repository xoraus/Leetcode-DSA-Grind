class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxSum(nums, 0, dp);
    }

    public int maxSum(int[] nums, int currIdx, int[] dp) {
        if (currIdx >= nums.length) return 0;
        
        if (dp[currIdx] != -1)
            return dp[currIdx];

        int robCurrent = nums[currIdx] + maxSum(nums, currIdx + 2, dp);
        int skipCurrent = maxSum(nums, currIdx + 1, dp);

        dp[currIdx] = Math.max(robCurrent, skipCurrent);
        return dp[currIdx];
    }
}