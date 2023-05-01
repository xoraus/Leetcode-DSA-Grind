class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        // Array not rotated at all: completely sorted
        if (n == 1 || nums[0] < nums[n - 1]) {
            return nums[0];
        }
        
        int left = 1, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid - 1] > nums[mid])
                return nums[mid];
            if (nums[mid] <= nums[right])
                right = mid - 1; // unrotated part: min in left side
            else
                left = mid + 1; // rotated part: min in right side
        }

        return -1;
    }
}