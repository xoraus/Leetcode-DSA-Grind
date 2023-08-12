class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;

        reverse(nums, 0, size - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, size - 1);
    }

    public static void reverse(int[] nums, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            int temp = nums[startIdx];
            nums[startIdx] = nums[endIdx];
            nums[endIdx] = temp;
            startIdx++;
            endIdx--;
        }
    }
}