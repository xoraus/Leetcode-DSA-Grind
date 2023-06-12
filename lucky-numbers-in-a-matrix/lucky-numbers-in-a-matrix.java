class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int minCol = 0; // column index
            
            for (int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] < matrix[row][minCol]){
                    minCol = col;
                }
            }
            
            int max = Integer.MIN_VALUE;
            
            for (int r = 0; r < matrix.length; r++) {
                if (matrix[r][minCol] > max) {
                    max = matrix[r][minCol];
                }
            }

            if (max == matrix[row][minCol]) { 
                List<Integer> res = new ArrayList<>();
                res.add(max);
                return res;
            }
        }

        return new ArrayList<>();
    }
}
