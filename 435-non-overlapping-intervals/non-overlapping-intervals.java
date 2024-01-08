class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals based on the starting points
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int removals = 0;
        
        if (intervals.length > 0) {
            // Initialize nextEnd with the ending point of the first interval
            int nextEnd = intervals[0][1];

            // Iterate through intervals to find minimum removals
            for (int i = 1; i < intervals.length; i++) {
                int[] curr = intervals[i];
                if (curr[0] < nextEnd) {
                    // Overlapping interval found, increment removals
                    removals++;
                    // Update nextEnd to the minimum ending point
                    nextEnd = Math.min(nextEnd, curr[1]);
                } else {
                    // Update nextEnd with the ending point of the current interval
                    nextEnd = curr[1];
                }
            }
        }

        // Return the minimum number of removals
        return removals;
    }
}
