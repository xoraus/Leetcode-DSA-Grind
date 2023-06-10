class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] result = new int[rows * cols];
        int index = 0;
        
        for (int diagonal = 0; diagonal < rows + cols - 1; diagonal++) {
            if (diagonal % 2 == 1) {
                // top right to bottom left
                int startRow = (diagonal < cols) ? 0 : diagonal - cols + 1;
                int startCol = (diagonal < cols) ? diagonal : cols - 1;
                
                while (startRow < rows && startCol >= 0) {
                    result[index++] = mat[startRow][startCol];
                    startRow++;
                    startCol--;
                }
            } else {
                // bottom left to top right
                int startRow = (diagonal < rows) ? diagonal : rows - 1;
                int startCol = (diagonal < rows) ? 0 : diagonal - rows + 1;
                
                while (startRow >= 0 && startCol < cols) {
                    result[index++] = mat[startRow][startCol];
                    startRow--;
                    startCol++;
                }
            }
        }
        
        return result;
    }
}