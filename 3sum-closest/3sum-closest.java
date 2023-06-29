class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0; // or any suitable default value
        }
        
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum == target) {
                    return sum; // Found the exact sum, return it
                }
                
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum; // Update the closest sum
                }
                
                if (sum < target) {
                    j++; // Move j to the right
                } else {
                    k--; // Move k to the left
                }
            }
        }
        return closestSum;
    }

}