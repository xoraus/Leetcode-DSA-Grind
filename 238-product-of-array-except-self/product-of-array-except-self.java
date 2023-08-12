class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int productOfAll = 1;
        int zeroCount = 0; // Count of zero values

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            productOfAll *= num;
        }

        for (int i = 0; i < n; i++) {
            if (zeroCount > 1) { // If more than one zero, all products are zero
                result[i] = 0;
            } else if (zeroCount == 1 && nums[i] == 0) { // If one zero, result is productOfAll
                result[i] = productOfAll;
            } else if (zeroCount == 0) { // If no zeros, regular division
                result[i] = productOfAll / nums[i];
            }
        }

        return result;
    }
}