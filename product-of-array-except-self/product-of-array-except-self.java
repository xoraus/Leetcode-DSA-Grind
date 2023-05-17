class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = getPrefix(nums);
        int[] suffix = getSuffix(nums);

        int n = nums.length;
        int[] answer = new int[n];


        for(int idx = 0; idx < n; idx++){
            int left = (idx > 0) ? prefix[idx - 1] : 1;
            int right = (idx < n - 1) ? suffix[idx + 1] : 1;
            answer[idx] = left * right; 
        }

        return answer;
        
    }

    public int[] getPrefix(int[] nums){
        int[] prefixSum = new int[nums.length];
        
        for(int idx = 0; idx < nums.length; idx++){
            prefixSum[idx] = nums[idx] *  ((idx > 0) ? prefixSum[idx - 1] : 1);
        }
        
        return prefixSum;
    }

    public int[] getSuffix(int[] nums){
        int[] suffixSum = new int[nums.length];
        int n = nums.length;

        for(int idx = n - 1; idx >= 0; idx--){
            suffixSum[idx] =nums[idx] * ((idx < n - 1) ? suffixSum[idx + 1] : 1) ;
        }
        
        return suffixSum;
    }
}