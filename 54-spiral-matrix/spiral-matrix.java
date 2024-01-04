class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        
        int numRows = matrix.length, numCols = matrix[0].length;
        int top = 0, bottom = numRows - 1, left = 0, right = numCols - 1;
        
        while (spiralList.size() < numRows * numCols) {
            // Traverse top row
            for (int col = left; col <= right && spiralList.size() < numRows * numCols; col++)
                spiralList.add(matrix[top][col]);
            top++;

            // Traverse right column
            for (int row = top; row <= bottom && spiralList.size() < numRows * numCols; row++)
                spiralList.add(matrix[row][right]);
            right--;

            // Traverse bottom row
            for (int col = right; col >= left && spiralList.size() < numRows * numCols; col--)
                spiralList.add(matrix[bottom][col]);
            bottom--;

            // Traverse left column
            for (int row = bottom; row >= top && spiralList.size() < numRows * numCols; row--)
                spiralList.add(matrix[row][left]);
            left++;
        }
        
        return spiralList;
    }

}