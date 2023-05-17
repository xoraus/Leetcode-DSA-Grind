class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = nums[0];
        for(int idx = 1; idx < nums.length; idx++){
            res[idx] = res[idx-1] + nums[idx];
        }
        
        return res;
    }
}