class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        int firstIndex = -1;
        int lastIndex = -1;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                continue;
            }

            if (firstIndex == -1) {
                firstIndex = i;
                lastIndex = i;
            } else {
                lastIndex = i;
            }
        }

        // All zeroes
        if (firstIndex == -1) {
            return (flowerbed.length + 1) / 2 >= n;
        }

        // Left
        max += firstIndex / 2;

        // Right
        max += (flowerbed.length - lastIndex - 1) / 2;

        // Middle
        int count = 0;
        for (int i = firstIndex + 1; i <= lastIndex - 1; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                max += (count - 1) / 2;
                count = 0;
            }
        }

        // Remaining part of the middle
        max += (count - 1) / 2;

        return max >= n;
    }
}
