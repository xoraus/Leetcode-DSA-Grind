class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int skipFirstHouse = helper(nums, 0, n - 2);
        int skipLastHouse = helper(nums, 1, n - 1);

        return Math.max(skipFirstHouse, skipLastHouse);

    }

    public int helper(int[] nums, int startIdx, int endIdx) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        
        return maxSum(nums, startIdx, endIdx, dp);
    }

    public int maxSum(int[] nums, int currIdx, int endIdx, int[] dp) {
        if (currIdx > endIdx) return 0;
        
        if (dp[currIdx] != -1)
            return dp[currIdx];

        int robCurrent = nums[currIdx] + maxSum(nums, currIdx + 2, endIdx, dp);
        int skipCurrent = maxSum(nums, currIdx + 1, endIdx, dp);
        
        return dp[currIdx] = Math.max(robCurrent, skipCurrent);
    }
}
