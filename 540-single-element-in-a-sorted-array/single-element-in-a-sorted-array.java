class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
        
        int low = 0, high = n - 1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if(nums[mid] == nums[mid - 1]){
                mid = mid - 1;
            }
            if(mid % 2 == 0){
                low = mid + 2;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}