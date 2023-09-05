class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                maxHeap.add(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.remove();
                }
            }
        }
        
        return maxHeap.peek();
    }
}