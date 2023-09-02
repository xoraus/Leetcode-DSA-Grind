public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long currentSum = 0;   // The sum of the current subarray of length k
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        long maxSum = currentSum;  // The maximum sum found so far
        
        for (int i = k; i < nums.length; i++) {
            // Update the current sum by adding the next element and subtracting the first element in the current subarray
            currentSum += nums[i] - nums[i - k];
            
            // Update the maximum sum if the current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // Return the maximum average by dividing the maximum sum by k
        return (double) maxSum / k;
    }
}