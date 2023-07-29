class Solution {
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int[] colorsCount = new int[3];

        // Count the occurrences of each color in the array
        for (int num : nums) {
            colorsCount[num]++;
        }

        int index = 0;

        // Reconstruct the array with the sorted colors
        for (int color = 0; color <= 2; color++) {
            while (colorsCount[color] > 0) {
                nums[index++] = color;
                colorsCount[color]--;
            }
        }
    }
}