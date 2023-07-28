class Solution {
    private int beautifulArrangementsCount;

    public int countArrangement(int n) {
        beautifulArrangementsCount = 0;
        generateBeautifulArrangements(n, new ArrayList<>());
        return beautifulArrangementsCount;
    }

    private void generateBeautifulArrangements(int n, List<Integer> currentArrangement) {
        if (currentArrangement.size() == n) {
            beautifulArrangementsCount++;
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (currentArrangement.contains(num)) {
                continue;
            }
            int currentIndex = currentArrangement.size() + 1;
            if (num % currentIndex == 0 || currentIndex % num == 0) {
                currentArrangement.add(num);
                generateBeautifulArrangements(n, currentArrangement);
                currentArrangement.remove(currentArrangement.size() - 1);
            }
        }
    }

}