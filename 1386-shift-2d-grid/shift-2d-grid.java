import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> shiftedGrid = new ArrayList<>(m);

        for (int i = 0; i < m; i++) {
            shiftedGrid.add(new ArrayList<>(n));
            for (int j = 0; j < n; j++) {
                shiftedGrid.get(i).add(0);
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int newIndex = ((r * n + c) + k) % (m * n);
                int newRow = newIndex / n;
                int newCol = newIndex % n;
                shiftedGrid.get(newRow).set(newCol, grid[r][c]);
            }
        }

        return shiftedGrid;
    }
}
