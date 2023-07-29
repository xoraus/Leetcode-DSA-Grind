class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;

        for (int idx = n - 1; idx >= 0; idx--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[idx] = nums[left] * nums[left];
                left++;
            } else {
                res[idx] = nums[right] * nums[right];
                right--;
            }
        }

        return res;
    }
}