class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int firstRow = 0, firstCol = 0;
        int lastRow = numRows - 1, lastCol = numCols - 1;
        int count = 0;
        
        List<Integer> spiralList = new ArrayList<>();
        
        while(count != numRows * numCols) {
            // Traverse first row
            for(int col = firstCol; col <= lastCol; col++) {
                spiralList.add(matrix[firstRow][col]);
                count++;
            }
            firstRow++;
            
            if(count == numRows * numCols) break;
            
            // Traverse last column
            for(int row = firstRow; row <= lastRow; row++) {
                spiralList.add(matrix[row][lastCol]);
                count++;
            }
            lastCol--;
            
            if(count == numRows * numCols) break;
            
            // Traverse last row
            for(int col = lastCol; col >= firstCol; col--) {
                spiralList.add(matrix[lastRow][col]);
                count++;
            }
            lastRow--;
            
            if(count == numRows * numCols) break;
            
            // Traverse first column
            for(int row = lastRow; row >= firstRow; row--) {
                spiralList.add(matrix[row][firstCol]);
                count++;
            }
            firstCol++;
            
            if(count == numRows * numCols) break;
        }
        
        return spiralList;
    }
}