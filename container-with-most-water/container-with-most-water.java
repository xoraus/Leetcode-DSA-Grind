class Solution {
    public int maxArea(int[] height) {
        int ptr1 = 0, ptr2 = height.length - 1;
        int maxWater = Integer.MIN_VALUE;   

        while(ptr1 <= ptr2){
            int buildHeight = Math.min(height[ptr1], height[ptr2]);
            int distance = ptr2 - ptr1;
            int containerCapacity = buildHeight * distance;
            
            maxWater = Math.max(containerCapacity, maxWater);
            
            if(height[ptr1] <= height[ptr2]){
                ptr1++;
            } else {
                ptr2--;
            }
        }
        return maxWater;  
    }
}