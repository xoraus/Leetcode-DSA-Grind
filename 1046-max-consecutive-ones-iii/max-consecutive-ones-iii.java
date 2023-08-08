class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0, countOfZeros = 0, leftPtr = 0;
        
        for(int rightPtr = 0; rightPtr < nums.length; rightPtr++){
            if(nums[rightPtr] == 0) countOfZeros++;

            // make subarray valid by excluding left elements
            while(countOfZeros > k){
                if(nums[leftPtr] == 0) countOfZeros--;
                leftPtr++;
            }

            maxLen = Math.max(maxLen, rightPtr - leftPtr + 1);
        }
        return maxLen;
    } 
}