class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int n = nums.length;
        
        // Iterate through all possible subarrays
        for (int left = 0; left < n; left++) {
            int zeroes = 0;
            
            for (int right = left; right < n; right++) {
                // Count the number of zeros in the current subarray
                if (nums[right] == 0) {
                    zeroes++;
                }
                
                // If the number of zeros is less than or equal to 'k',
                // update the maximum length of consecutive ones
                if (zeroes <= k) {
                    maxLength = Math.max(maxLength, right - left + 1);
                } else {
                    // If the number of zeros exceeds 'k', break the loop
                    break;
                }
            }
        }
        
        return maxLength;
    }
}