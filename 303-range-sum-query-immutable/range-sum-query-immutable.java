class NumArray {
    private int[] prefixSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n + 1];
        
        // Calculate the prefix sum array
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        // To calculate the sum between left and right (inclusive),
        // we use prefixSum[right + 1] - prefixSum[left].
        return prefixSum[right + 1] - prefixSum[left];
    }
}
