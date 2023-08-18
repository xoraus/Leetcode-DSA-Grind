class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
            adj.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }

        int maxRank = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                int i_rank = adj.getOrDefault(i, Collections.emptySet()).size();
                int j_rank = adj.getOrDefault(j, Collections.emptySet()).size();
                
                int rank = i_rank + j_rank;
                
                
                if (adj.getOrDefault(i, Collections.emptySet()).contains(j)) {
                    rank--;
                }
                
                maxRank = Math.max(maxRank, rank);
            }
        }
 
        return maxRank;
    }
}