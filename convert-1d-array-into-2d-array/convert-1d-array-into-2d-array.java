class Solution {
    // Appraoch 2: 

    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length) return new int[0][0];

        int[][] mat = new int[m][n];

        for(int idx = 0; idx < original.length; idx++){
            int row = idx / n;
            int col = idx % n;
            mat[row][col] = original[idx];
        }

        return mat;
    }
}