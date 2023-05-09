public class Solution {
    public static boolean isPossible(int[] position, int minDist, int totalBalls) {
        int placedBalls = 1, lastIdx = 0;

        for (int currentIdx = 1; currentIdx < position.length; currentIdx++) {
            int dist = position[currentIdx] - position[lastIdx];

            if (dist >= minDist) {
                placedBalls++;
                lastIdx = currentIdx;
            }
        }

        return (placedBalls >= totalBalls);
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(position, mid, m)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
