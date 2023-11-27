class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // dp[i][j] stores the maximum number of uncrossed lines between nums1[0:i] and nums2[0:j]
        int[][] dp = new int[m + 1][n + 1];

        // Traverse the arrays from the end to the beginning
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    // If the elements at the current positions match, extend the uncrossed line
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    // If the elements do not match, take the maximum uncrossed lines from the adjacent positions
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        // The result is stored in dp[0][0], which represents the maximum uncrossed lines between the entire arrays
        return dp[0][0];
    }

}