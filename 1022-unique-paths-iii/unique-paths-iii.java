class Solution {
    int startRow = -1, startCol = -1;
    int finishRow = -1, finishCol = -1;
    
    public int uniquePathsIII(int[][] grid) {
        int freeCells = 1; // at least 1 starting cell

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 0) freeCells++;
                if(grid[row][col] == 1){
                    startRow = row;
                    startCol = col;
                }
                if(grid[row][col] == 2){
                    finishRow = row;
                    finishCol = col;
                }   
            }
        }
        return countPaths(grid, startRow, startCol, freeCells);
    }

    public int countPaths(int[][] mat, int row, int col, int freeCells) {
        if (row < 0 || col < 0 || row == mat.length || col == mat[0].length) {
            // Index out of bounds -> negative base case
            return 0;
        }
        if (mat[row][col] == -2 || mat[row][col] == -1) {
            // Visited cell or blocked cell -> negative base case
            return 0;
        }
        if (row == finishRow && col == finishCol) {
            // Destination -> positive base case
            if (freeCells == 0) return 1;
            else return 0;
        }

        mat[row][col] = -1; // Visited mark
        
        int paths = 0;
        
        paths += countPaths(mat, row - 1, col, freeCells - 1);
        paths += countPaths(mat, row + 1, col, freeCells - 1);
        paths += countPaths(mat, row, col - 1, freeCells - 1);
        paths += countPaths(mat, row, col + 1, freeCells - 1);

        mat[row][col] = 0; // Unvisited mark (backtracking)
        
        return paths;
    }

}