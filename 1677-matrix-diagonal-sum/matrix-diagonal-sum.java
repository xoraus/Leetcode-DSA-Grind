class Solution {
    public int diagonalSum(int[][] matrix) {
        int result = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            result += matrix[i][i]; 
            result += matrix[size - 1 - i][i]; 
        }

        return size % 2 == 0 ? result : result - matrix[size / 2][size / 2];
    }
}
