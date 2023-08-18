class Graph {
    private int n;
    private ArrayList<Integer>[] adj;

    public Graph(int n) {
        this.n = n;
        adj = new ArrayList[n];
        for (int idx = 0; idx < n; idx++) {
            adj[idx] = new ArrayList<>();
        }
    }

    public int getN() {
        return n;
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src); // If undirected
    }

    public ArrayList<Integer>[] getAdjacencyList() {
        return adj;
    }
}

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Graph graph = new Graph(n);

        for (int[] road : roads) {
            graph.addEdge(road[0], road[1]);
        }

        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = graph.getAdjacencyList()[i].size() + graph.getAdjacencyList()[j].size();

                // If there's a direct edge between these cities, reduce the count by 1
                if (graph.getAdjacencyList()[i].contains(j)) {
                    rank--;
                }

                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }
}
