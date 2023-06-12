class Solution {
    // Appraoch 1: 
    
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length) return new int[0][0];

        int[][] mat = new int[m][n];

        int idx = 0;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                mat[row][col] = original[idx++];
            }
        }

        return mat;
    }
}