class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        if (n == 0) return;

        // Get the effective number of rotations:
        k = k % n;

        // If k is 0, the array remains unchanged
        if (k == 0) return;

        int[] temp = new int[k]; // temporary array

        // Step 1: Copy the last k elements to the temporary array
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }

        // Step 2: Shift the first (n - k) elements to the right by k places
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        // Step 3: Place the elements of the temporary array at the beginning of the array
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
