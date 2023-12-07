class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0, firstIndex = -2, lastIndex = -1;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                max += (i - firstIndex - 2) / 2;
                firstIndex = i;
            }
        }

        max += (flowerbed.length - firstIndex - 1) / 2;
        return max >= n;
    }
}
