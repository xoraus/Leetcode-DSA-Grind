class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        for(int idx = 0; idx < nums.length; idx++){
            if(nums[idx] > nums[(idx + 1) % nums.length]){
                count++;
            }
            if(count>1){
                return false;
            }
        }    

        return true; 
    }
}
