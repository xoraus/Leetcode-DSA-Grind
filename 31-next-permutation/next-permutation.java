class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakPoint = findBreakPoint(nums, n);

        if (breakPoint == -1) {
            reverse(nums, 0, n - 1);
        } else {
            int nextGreaterIndex = findNextGreater(nums, breakPoint, n);
            swap(nums, breakPoint, nextGreaterIndex);
            reverse(nums, breakPoint + 1, n - 1);
        }
    }

    private int findBreakPoint(int[] nums, int n) {
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private int findNextGreater(int[] nums, int breakPoint, int n) {
        for (int i = n - 1; i > breakPoint; i--) {
            if (nums[i] > nums[breakPoint]) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}