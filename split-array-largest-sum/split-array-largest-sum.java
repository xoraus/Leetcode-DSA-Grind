class Solution {
    public static boolean isPossible(int[] nums, int maxSum, int k) {
        int requiredSubarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                requiredSubarrays++;
                currentSum = num;
            }
        }

        return (requiredSubarrays <= k);
    }

    public static int maxOfArray(int[] nums) {
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);
        return max;
    }

    public static int sumOfArray(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum;
    }

    public int splitArray(int[] nums, int k) {
        // Maximum sum will be at least the maximum number in the array
        int left = maxOfArray(nums); 

        // Maximum sum can be the sum of all numbers in the array
        int right = sumOfArray(nums); 

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(nums, mid, k))
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
}
