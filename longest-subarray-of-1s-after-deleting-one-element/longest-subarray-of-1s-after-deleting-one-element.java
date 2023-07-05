class Solution {
    public int longestSubarray(int[] nums) {
        int prev = 0, curr = 0, maxOnes = 0;
        for(int val: nums){
            if(val == 1) curr++;
            else {
                maxOnes = Math.max(maxOnes, curr + prev);
                prev = curr;
                curr = 0;
            }
        }
        maxOnes = Math.max(maxOnes, curr + prev);
        return maxOnes == nums.length ? maxOnes - 1 : maxOnes;
    }
}