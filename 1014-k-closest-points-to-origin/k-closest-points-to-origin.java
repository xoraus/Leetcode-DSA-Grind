class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            double distance1 = Math.sqrt(p1[0] * p1[0] + p1[1] * p1[1]);
            double distance2 = Math.sqrt(p2[0] * p2[0] + p2[1] * p2[1]);
            
            // max-heap
            if (distance1 < distance2) {
                return +1;
            } else if (distance2 < distance1) {
                return -1;
            } else {
                return 0;
            }
        });

        for (int[] point : points) {
            if (pq.size() < k) {
                pq.add(point);
            } else {
                pq.add(point);
                pq.remove();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove();
        }

        return result;
    }
}