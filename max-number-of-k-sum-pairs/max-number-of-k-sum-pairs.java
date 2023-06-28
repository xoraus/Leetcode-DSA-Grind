class Solution {
    public int maxOperations(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;

        int left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] > target){
                right--;
            } else if(nums[left] + nums[right] < target){
                left++;
            } else {
                count++;
                
                left++; right--;
            }
        }
        return count;
    }
}