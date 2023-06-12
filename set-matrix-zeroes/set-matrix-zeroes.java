class Solution {
    public void setZeroes(int[][] mat) {
        boolean r0Zero = false, c0Zero = false;

        // Queries -> Store Zeroes
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 0) {
                    mat[0][col] = mat[row][0] = 0;
                    if (row == 0) r0Zero = true;
                    if (col == 0) c0Zero = true;
                }
            }
        }

        // Updates -> Set Zeros
        for (int row = 1; row < mat.length; row++) {
            for (int col = 1; col < mat[0].length; col++) {
                if (mat[row][0] == 0 || mat[0][col] == 0) {
                    mat[row][col] = 0;
                }
            }
        }

        // first Row (r0)
        if (r0Zero == true) {
            for (int col = 0; col < mat[0].length; col++) {
                mat[0][col] = 0;
            }
        }

        // first Col (c0)
        if (c0Zero == true) {
            for (int row = 0; row < mat.length; row++) {
                mat[row][0] = 0;
            }
        }
    }
}
