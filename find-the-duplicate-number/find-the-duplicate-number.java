class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        // Pass 1: Mark Visited
        for(int i=0; i<n; i++){
            int val = nums[i] % (n+1);
            nums[val] += (n+1);
        }

        // Pass 2: Find Dumplicates
        for(int i=0; i<n; i++){
            int freq = nums[i] / (n+1);
            if(freq > 1) return i;
        }
        
        return -1;
    }
}