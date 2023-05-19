class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // Pass 1: Out of Range = Discard: Make them 0
        for(int idx = 0; idx < n; idx++){
            if(nums[idx] <= 0 || nums[idx] > n){
                nums[idx] = 0;
            }
        }

        // Pass 2: Mark Visited
        for(int idx = 0; idx < n; idx++){
            int val = nums[idx] % (n + 1);
            if(val > 0) nums[val-1] += (n+1);
        }
        // Pass 3: Missing +ve Integer
        for(int idx = 0; idx < n; idx++){
            int freq = nums[idx] / (n + 1);
            if(freq == 0) return idx + 1;
        }

        return (n + 1); // corner case
    }
}