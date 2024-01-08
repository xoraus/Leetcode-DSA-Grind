class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (t, o) -> Integer.compare(o[0], t[0]));

        int removals = 0, nextEnd = Integer.MAX_VALUE;

        for (int[] curr : intervals) {
            if (curr[1] <= nextEnd) {
                nextEnd = curr[0];
            } else {
                removals++;
            }
        }

        return removals;
    }
}