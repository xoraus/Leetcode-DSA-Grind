class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0, firstIndex = -1, lastIndex = -1, count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (firstIndex == -1) firstIndex = i;
                lastIndex = i;
            }
        }
        if (firstIndex == -1) return (flowerbed.length + 1) / 2 >= n;
        max += firstIndex / 2 + (flowerbed.length - lastIndex - 1) / 2;
        for (int i = firstIndex + 1; i <= lastIndex - 1; i++) {
            if (flowerbed[i] == 0) count++;
            else {
                max += (count - 1) / 2;
                count = 0;
            }
        }
        max += (count - 1) / 2;
        return max >= n;
    }
}
