class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            // if mid is the target
            if(nums[mid] == target) return mid;

            // if left half part is sorted
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    // element exists
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // if right half part is sorted
                if(nums[mid] <= target && target <= nums[high]){
                    // element exists
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}