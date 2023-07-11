class Solution {
    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return; // Out of matrix
        }
        if (grid[row][col] == '0' || grid[row][col] == 'V') {
            return; // Water cell or visited land
        }
        grid[row][col] = 'V'; // Visiting a land
        dfs(grid, row - 1, col); // Top
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    islands++;
                    dfs(grid, row, col);
                }
            }
        }
        return islands;
    }
}