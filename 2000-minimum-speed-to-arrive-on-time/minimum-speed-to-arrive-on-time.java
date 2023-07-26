class Solution {
    public int minSpeedOnTime(int[] distances, double hour) {
        int minSpeed = 1;
        int maxSpeed = 10000007; // Set an upper bound for the binary search

        while (minSpeed <= maxSpeed) {
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
            if (isPossible(distances, hour, midSpeed)) {
                maxSpeed = midSpeed - 1;
            } else {
                minSpeed = midSpeed + 1;
            }
        }

        // If minSpeed > 10000000, it means the answer is not possible
        return minSpeed > 10000000 ? -1 : minSpeed;
    }

    public boolean isPossible(int[] distances, double maxCommuteHour, int speed) {
        double totalCommuteTime = 0;
        for (int i = 0; i < distances.length - 1; i++) {
            totalCommuteTime += Math.ceil((double) distances[i] / speed);
        }
        totalCommuteTime += (double) distances[distances.length - 1] / speed;
        return totalCommuteTime <= maxCommuteHour;
    }

}