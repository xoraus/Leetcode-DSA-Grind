class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int firstRow = 0, firstCol = 0;
        int lastRow = n - 1, lastCol = n - 1;

        while (firstRow <= lastRow && firstCol <= lastCol) {
            // Traverse from left to right in the first row
            for (int col = firstCol; col <= lastCol; col++) {
                matrix[firstRow][col] = num++;
            }
            firstRow++;

            // Traverse from top to bottom in the last column
            for (int row = firstRow; row <= lastRow; row++) {
                matrix[row][lastCol] = num++;
            }
            lastCol--;

            // Traverse from right to left in the last row
            if (firstRow <= lastRow) {
                for (int col = lastCol; col >= firstCol; col--) {
                    matrix[lastRow][col] = num++;
                }
                lastRow--;
            }

            // Traverse from bottom to top in the first column
            if (firstCol <= lastCol) {
                for (int row = lastRow; row >= firstRow; row--) {
                    matrix[row][firstCol] = num++;
                }
                firstCol++;
            }
        }

        return matrix;
    }
}
