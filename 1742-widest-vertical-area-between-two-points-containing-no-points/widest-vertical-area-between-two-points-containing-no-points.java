class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xPoints = new int[points.length];
        int i = 0;
        int maxArea = 0;
        
        for(int[] x: points){
            xPoints[i++] = x[0];
        }

        Arrays.sort(xPoints);

        
        for(int idx = 0; idx < xPoints.length - 1; idx++){
            maxArea = Math.max(maxArea, xPoints[idx + 1] - xPoints[idx]);
        }
        
        return maxArea;
    }
}


