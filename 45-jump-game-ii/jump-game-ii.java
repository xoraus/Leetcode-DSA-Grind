public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxReachable = 0;
        int currentEnd = 0;
        int jumps = 0;

        for (int i = 0; i < n - 1; i++) {
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReachable;
            }
        }

        return jumps;
    }
}
