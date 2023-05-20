class Solution {
    public int maxArea(int[] height) {
        int leftPtr = 0, rightPtr = height.length - 1;
        int maxWater = Integer.MIN_VALUE;   

        while (leftPtr <= rightPtr) {
            int minHeight = Math.min(height[leftPtr], height[rightPtr]);
            int width = rightPtr - leftPtr;
            int containerCapacity = minHeight * width;

            maxWater = Math.max(containerCapacity, maxWater);

            if (height[leftPtr] <= height[rightPtr]) {
                leftPtr++;
            } else {
                rightPtr--;
            }
        }
        return maxWater;
    }
}