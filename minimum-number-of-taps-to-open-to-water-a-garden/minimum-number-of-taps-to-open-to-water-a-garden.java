class Solution {
    public int minTaps(int n, int[] ranges) {
        // Creating Jumps Array by Making Interval's Left Value as Range Value
        int[] jumps = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            jumps[left] = Math.max(jumps[left], right - left);
        }

        // Same Code as Jump Game - II
        int minTaps = jump(jumps);
        return minTaps == Integer.MAX_VALUE ? -1 : minTaps ;
    }
    
    public int jump(int[] jumpLengths) {
        int n = jumpLengths.length;
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        
        return (int)minimumJumpsToEnd(0, jumpLengths, memo);
    }

    public long minimumJumpsToEnd(int currPos, int[] jumpLengths, long[] memo) {
        if (currPos >= jumpLengths.length - 1) {
            return 0; // Minimum number of moves to go from current position to destination is 0
        }
        if (memo[currPos] != -1) {
            return memo[currPos];
        }
        
        long minJumps = Integer.MAX_VALUE;
        for (int jump = 1; jump <= jumpLengths[currPos]; jump++) {
            if (currPos + jump < jumpLengths.length) {
                minJumps = Math.min(minJumps, minimumJumpsToEnd(currPos + jump, jumpLengths, memo) + 1);
            }
        }
        memo[currPos] = minJumps;
        return minJumps;
    }
}
