class Solution {
    public int numSquares(int n) {
        int[] minPerfectSq = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            minPerfectSq[i] = i; // Initialize with the maximum possible value

            // Iterate through all possible perfect squares less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                // Update the minimum number of perfect squares needed for i
                minPerfectSq[i] = Math.min(minPerfectSq[i], minPerfectSq[i - j * j] + 1);
            }
        }

        return minPerfectSq[n];
    }
}
