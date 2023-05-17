class Solution {

    public int[] getPrefix(int[] nums){
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        
        for(int idx = 1; idx < nums.length; idx++){
            prefixSum[idx] = prefixSum[idx-1] + nums[idx];
        }
        
        return prefixSum;
    }
    public int[] getSuffix(int[] nums){
        int n = nums.length;
        int[] suffixSum = new int[nums.length];
        suffixSum[n - 1] = nums[n - 1];

        for(int idx = n - 2; idx >= 0; idx--){
            suffixSum[idx] = suffixSum[idx + 1] + nums[idx];
        }
        
        return suffixSum;
    }

    public int pivotIndex(int[] nums) {
        int[] prefix = getPrefix(nums);
        int[] suffix = getSuffix(nums);

        // left t right: leftmost pivot index
        for(int idx = 0; idx < nums.length; idx++){
            if(prefix[idx] == suffix[idx]){
                return idx;
            }
        }

        // no pivot index
        return -1;
    }
}