class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int trappedWater = 0;

        for (int i = 1; i < n - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            // Find the maximum height on the left side of the current bar
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find the maximum height on the right side of the current bar
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // Calculate the trapped water at the current bar
            int minHeight = Math.min(leftMax, rightMax);
            if (minHeight > height[i]) {
                trappedWater += minHeight - height[i];
            }
        }

        return trappedWater;
    }
}

