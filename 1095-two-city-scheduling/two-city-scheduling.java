class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int costDifferenceA = a[1] - a[0];
                int costDifferenceB = b[1] - b[0];
                return costDifferenceB - costDifferenceA;
            }
        });

        int totalCost = 0;
        int firstHalf = costs.length / 2;

        for (int idx = 0; idx < firstHalf; idx++) {
            totalCost += costs[idx][0];
        }

        for (int idx = firstHalf; idx < costs.length; idx++) {
            totalCost += costs[idx][1];
        }

        return totalCost;
    }
}