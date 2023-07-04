class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        if(nums.length < 3) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n - 1] != nums[n - 2]) return nums[n - 1];

        for(int idx = 1; idx < nums.length - 2; idx = idx + 3){
            if(nums[idx] != nums[idx - 1]){
                return nums[idx - 1];
            }
        }
        return -1;
    }   
}