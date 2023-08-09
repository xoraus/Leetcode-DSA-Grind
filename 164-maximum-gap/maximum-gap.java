class Solution {
    public int[] countSort(int[] nums, int place) {
        int[] freq = new int[10]; // Assuming input elements are between 0 and 100

        // Pass 1: Count the frequency of each element in the input array (O(N))
        for (int ele : nums) {
            int digit = (ele / place) % 10;
            freq[digit]++;
        }

        // Pass 2: Convert frequency array to prefix sum array (O(d))
        for (int idx = 1; idx < freq.length; idx++) {
            freq[idx] += freq[idx - 1];
        }

        // Pass 3: Create the output sorted array (O(N))
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int ele = nums[i];
            int digit = (ele % (10 * place)) / place;
            int last = freq[digit]--;
            res[last - 1] = ele;
        }

        return res;
    }

    public int maximumGap(int[] nums) {
        int maxGap = 0;

        // Radix Sort
        for (int place = 1; place <= (int)10e8; place *= 10) {
            nums = countSort(nums, place);
        }

        // Calculate maximum gap
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }

        return maxGap;
    }

}