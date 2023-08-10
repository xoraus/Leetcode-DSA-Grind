class Solution {
    static class Interval implements Comparable<Interval> {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval other) {
            if (this.start < other.start)
                return -1;
            else if (this.start > other.start)
                return +1;
            return 0;
        }
    }

    public int[][] merge(int[][] intervals) {
        PriorityQueue<Interval> intervalQueue = new PriorityQueue<>();
        for (int[] interval : intervals)
            intervalQueue.add(new Interval(interval[0], interval[1]));

        List<Interval> mergedIntervals = new ArrayList<>();
        while (intervalQueue.size() > 0) {
            Interval currentInterval = intervalQueue.remove();
            Interval lastMerged = (mergedIntervals.size() == 0) ? null
                    : mergedIntervals.get(mergedIntervals.size() - 1);

            if (lastMerged == null || lastMerged.end < currentInterval.start)
                mergedIntervals.add(currentInterval);
            else
                lastMerged.end = Math.max(lastMerged.end, currentInterval.end);
        }

        int[][] resultMatrix = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            resultMatrix[i][0] = mergedIntervals.get(i).start;
            resultMatrix[i][1] = mergedIntervals.get(i).end;
        }
        return resultMatrix;
    }
}
