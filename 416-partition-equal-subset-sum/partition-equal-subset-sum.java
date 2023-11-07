class Solution {

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int val : nums) {
            total += val;
        }
        
        if (total % 2 != 0) {
            return false; // No division possible for an odd sum
        }

        return checkTargetSumSubset(nums, total / 2);
    }

    public boolean checkTargetSumSubset(int[] arr, int target) {
        int n = arr.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Empty Subset to form a sum of 0
        
        for (int i = 0; i < n; i++) {
            boolean[] newdp = new boolean[target + 1];
            for (int j = 0; j <= target; j++) {
                boolean no = dp[j]; // Exclude the current element
                boolean yes = (j >= arr[i]) ? dp[j - arr[i]] : false; // Include the current element
                newdp[j] = no || yes;
            }
            dp = newdp;
        }

        return dp[target];
    }

}