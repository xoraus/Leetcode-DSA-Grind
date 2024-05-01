class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int idx = 0; idx < nums.length - 1; idx++) {
            if (nums[idx] > nums[idx + 1]) {
                increasing = false;
            } else if (nums[idx] < nums[idx + 1]) {
                decreasing = false;
            }

            if(!increasing && !decreasing){
                return false;
            }
        }

        return increasing || decreasing;
    }
}
