class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length + 5];
        Arrays.fill(dp, -1);
        
        int moves = memoization(0, nums.length - 1, nums, dp);
        
        return moves;
    }

    public int memoization(int src, int dest, int[] nums, int[] dp) {
        if (src == dest) return 0;
        if (src > dest) return (int) 1e7; // Infinity
        if (dp[src] != -1) return dp[src];
        
        int ans = (int) 1e7; // Initialize with a large value
        
        for (int jump = 1; jump <= nums[src]; jump++) {
            int moves = memoization(src + jump, dest, nums, dp);
            ans = Math.min(ans, moves + 1);
        }
        
        return dp[src] = ans;
    }
}