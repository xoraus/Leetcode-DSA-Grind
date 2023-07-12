class Solution {
    public void dfs(int row, int col, int[][] image, int oldColor, int newColor){
        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length) return;
        
        if(image[row][col] != oldColor) return;
        image[row][col] = newColor;

        dfs(row - 1, col, image, oldColor, newColor);
        dfs(row + 1, col, image, oldColor, newColor);
        dfs(row, col - 1, image, oldColor, newColor);
        dfs(row, col + 1, image, oldColor, newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor != newColor){
            dfs(sr, sc, image, oldColor, newColor);
        }
        return image;
    }
}

