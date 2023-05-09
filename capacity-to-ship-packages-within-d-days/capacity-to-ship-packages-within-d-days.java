public class Solution {
    public static boolean isPossible(int[] weights, int maxLoad, int days) {
        int requiredDays = 1, currentLoad = 0;
        for (int weight : weights) {
            if (currentLoad + weight <= maxLoad) {
                currentLoad += weight;
            } else {
                requiredDays++;
                currentLoad = weight;
            }
        }
        return (requiredDays <= days);
    }

    public static int maxOfArray(int[] weights) {
        int max = 0;
        for (int weight : weights)
            max = Math.max(max, weight);
        return max;
    }

    public static int sumOfArray(int[] weights) {
        int sum = 0;
        for (int weight : weights)
            sum += weight;
        return sum;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = maxOfArray(weights);
        int right = sumOfArray(weights);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(weights, mid, days) == true)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
