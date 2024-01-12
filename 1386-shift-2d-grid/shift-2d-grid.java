class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);

        while (k > 0) {
            int[][] newGrid = copyGrid(grid); // Use the separate copy function

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (col < n - 1) {
                        grid[row][col + 1] = newGrid[row][col];
                    } else if (row < m - 1) {
                        grid[row + 1][0] = newGrid[row][col];
                    } else {
                        grid[0][0] = newGrid[row][col];
                    }
                }
            }

            k--;
        }

        return convertToList(grid); // Convert the 2D array to List<List<Integer>> for output
    }

    // Separate function to copy the grid
    private int[][] copyGrid(int[][] original) {
        int m = original.length;
        int n = original[0].length;
        int[][] copy = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                copy[row][col] = original[row][col];
            }
        }

        return copy;
    }

    // Separate function to convert the 2D array to List<List<Integer>>
    private List<List<Integer>> convertToList(int[][] array) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] rowArray : array) {
            List<Integer> rowList = new ArrayList<>();
            for (int value : rowArray) {
                rowList.add(value);
            }
            result.add(rowList);
        }
        return result;
    }
}
