class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0; // Initialize max here

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    int result = travelAndCollectGold(grid, i, j);
                    max = Math.max(max, result);
                }
            }
        }

        return max;
    }

    public int travelAndCollectGold(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        
        int currentGold = grid[i][j];
        grid[i][j] = 0; // Mark this cell as visited
        
        int up = travelAndCollectGold(grid, i - 1, j);
        int down = travelAndCollectGold(grid, i + 1, j);
        int left = travelAndCollectGold(grid, i, j - 1);
        int right = travelAndCollectGold(grid, i, j + 1);
        
        grid[i][j] = currentGold; // Restore the original value
        
        return currentGold + Math.max(Math.max(up, down), Math.max(left, right));
    }
}
