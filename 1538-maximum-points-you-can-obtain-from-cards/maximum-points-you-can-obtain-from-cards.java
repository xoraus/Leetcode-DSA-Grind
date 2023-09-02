class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int currentPoints = 0;
        int maxPoints = 0;

        for (int i = 0; i < k; i++) {
            currentPoints += cardPoints[i];
        }

        maxPoints = currentPoints;
        int endIndex = n - 1;

        for (int i = k - 1; i >= 0; i--) {
            currentPoints = currentPoints + cardPoints[endIndex] - cardPoints[i];
            maxPoints = Math.max(currentPoints, maxPoints);
            endIndex--;
        }
        
        return maxPoints;
    }
}