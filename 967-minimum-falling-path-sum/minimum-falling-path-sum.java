class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        
        int[][] dp = new int[numRows][numCols];
        
        // Initialize the bottom row of dp with the values from the matrix.
        for (int col = 0; col < numCols; col++) {
            dp[numRows - 1][col] = matrix[numRows - 1][col];
        }

        // Build up the dp table from the second-to-last row to the first row.
        for (int row = numRows - 2; row >= 0; row--) {
            for (int col = 0; col < numCols; col++) {
                int currentVal = matrix[row][col];
                int minPathSum = Integer.MAX_VALUE;

                // Consider the three possible paths from the cell (row, col) in the next row.
                for (int nextCol = col - 1; nextCol <= col + 1; nextCol++) {
                    if (nextCol >= 0 && nextCol < numCols) {
                        minPathSum = Math.min(minPathSum, dp[row + 1][nextCol]);
                    }
                }

                dp[row][col] = currentVal + minPathSum;
            }
        }

        // Find the minimum path sum in the top row of dp.
        int minPathSum = Integer.MAX_VALUE;
        for (int col = 0; col < numCols; col++) {
            minPathSum = Math.min(minPathSum, dp[0][col]);
        }

        return minPathSum;
    }
    
}