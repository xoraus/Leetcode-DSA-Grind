public class Solution {
    public long minimumJumpsToEnd(int currentPosition, int[] jumpLengths, long[] memo) {
        if (currentPosition >= jumpLengths.length - 1) {
            return 0; // Minimum number of moves to go from current position to destination is 0
        }
        if (memo[currentPosition] != -1) {
            return memo[currentPosition];
        }
        
        long minJumps = Integer.MAX_VALUE;
        for (int jump = 1; jump <= jumpLengths[currentPosition]; jump++) {
            if (currentPosition + jump < jumpLengths.length) {
                minJumps = Math.min(minJumps, minimumJumpsToEnd(currentPosition + jump, jumpLengths, memo) + 1);
            }
        }
        memo[currentPosition] = minJumps;
        return minJumps;
    }
    
    public int jump(int[] jumpLengths) {
        int n = jumpLengths.length;
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        
        return (int)minimumJumpsToEnd(0, jumpLengths, memo);
    }
}
