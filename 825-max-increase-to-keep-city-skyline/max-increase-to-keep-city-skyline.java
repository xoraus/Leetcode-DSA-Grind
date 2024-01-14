class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] maxRow = new int[n];
        int[] maxCol = new int[n];

        // Find the maximum height in each row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }

        int maxSum = 0;

        // Calculate the maximum total sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxSum += Math.min(maxRow[i], maxCol[j]) - grid[i][j];
            }
        }

        return maxSum;
    }

}