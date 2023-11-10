class Solution {
    public static int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();

        // Build adjacency map
        for (int[] pair : adjacentPairs) {
            adjacencyMap.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            adjacencyMap.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        // Find the starting point
        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        // Reconstruct the array
        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        Set<Integer> visited = new HashSet<>();
        result[0] = start;
        visited.add(start);

        for (int i = 1; i < n; i++) {
            List<Integer> neighbors = adjacencyMap.get(result[i - 1]);
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    result[i] = neighbor;
                    visited.add(neighbor);
                    break;
                }
            }
        }

        return result;
    }
}