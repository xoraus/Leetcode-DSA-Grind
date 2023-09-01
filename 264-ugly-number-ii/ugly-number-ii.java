class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;

        PriorityQueue<Long> q = new PriorityQueue<>();
        q.add(1L);
        HashSet<Long> vis = new HashSet<>();

        int idx = 0;
        while (q.size() > 0) {
            long min = q.remove();
            if (vis.contains(min) == true)
                continue;

            idx++;
            if (idx == n) return (int) min;

            vis.add(min);
            q.add(min * 2L);
            q.add(min * 3L);
            q.add(min * 5L);
        }

        return 1;
    }
}