class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3]; // {s, e, p}

        for (int i = 0; i < n; i++)
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};

        Arrays.sort(jobs, Comparator.comparingInt(vec -> vec[0]));

        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return helper(jobs, 0, memo);
    }

    private int helper(int[][] jobs, int i, int[] memo) {
        if (i >= jobs.length) return 0;
        if (memo[i] != -1) return memo[i];

        int next = getNextIndex(jobs, i + 1, jobs[i][1]);
        int taken = jobs[i][2] + helper(jobs, next, memo);
        int notTaken = helper(jobs, i + 1, memo);

        return memo[i] = Math.max(taken, notTaken);
    }

    private int getNextIndex(int[][] jobs, int l, int currentJobEnd) {
        int r = jobs.length - 1;
        int result = jobs.length + 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (jobs[mid][0] >= currentJobEnd) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }
}
