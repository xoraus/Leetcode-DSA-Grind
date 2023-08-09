class Solution {
    public int[] sortArray(int[] nums) {
        int min = -50000, max = 50000;
        int[] freq = new int[max - min + 1];

        // Pass 1: Count the frequency of each element in the input array (O(N))
        for (int ele : nums) {
            freq[ele - min]++;
        }

        // Pass 2: Convert frequency array to prefix sum array (O(d))
        for (int idx = 1; idx < freq.length; idx++) {
            freq[idx] += freq[idx - 1];
        }

        // Pass 3: Create the output sorted array (O(N))
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int ele = nums[i];
            int last = freq[ele - min]--;
            res[last - 1] = ele;
        }

        return res;
    }
}