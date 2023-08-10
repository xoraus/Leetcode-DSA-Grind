class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] < b[0]) return -1;
            else if(a[0] > b[0]) return +1;
            else return 0;
        });
        //Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int nonOverlappingLimit = Integer.MAX_VALUE;
        int intervalsToRemove = 0;

        for (int i = intervals.length - 1; i >= 0; i--) {
            if (intervals[i][1] <= nonOverlappingLimit) {
                // Non-overlapping interval
                nonOverlappingLimit = Math.min(nonOverlappingLimit, intervals[i][0]);
            } else {
                intervalsToRemove++;
            }
        }

        return intervalsToRemove;
    }
}
