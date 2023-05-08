class Solution {
    public boolean isPossible(int[] nums, long divisor, long threshold) {
        long sum = 0;
        
        // for (int num : nums) {
        //     sum += (long) Math.ceil((double) num / divisor);
        // }
        
        for(int num: nums){
            sum += num / divisor;
            if(num % divisor != 0){
                sum++;
            }
        }
        return (sum <= threshold);
    }

    public int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        long left = 1L, right = getMax(nums);
        while (left <= right) {
            long mid = left + (right - left) / 2L;
            if (isPossible(nums, mid, threshold)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }
}
