class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // Pass 1: Out of Range = Discard: Make them 0
        for(int i=0; i<n; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = 0;
            }
        }

        // Pass 2: Mark Visited
        for(int i=0; i<n; i++){
            int val = nums[i] % (n+1);
            if(val > 0) nums[val-1] += (n+1);
        }
        // Pass 3: Missing +ve Integer
        for(int i=0; i<n; i++){
            int freq = nums[i] / (n+1);
            if(freq == 0) return i+1;
        }

        return n+1; // corner case
    }
}