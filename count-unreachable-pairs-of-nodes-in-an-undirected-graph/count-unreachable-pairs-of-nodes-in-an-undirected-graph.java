class Graph {
    public int n;
    public ArrayList<Integer>[] adj;

    public Graph(int n) {
        this.n = n;
        adj = new ArrayList[n];
        for (int idx = 0; idx < n; idx++) {
            adj[idx] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src); 
    }

    public long dfs(int src, boolean[] visited){
        if(visited[src] == true) return 0l;
        long size = 1l;
        visited[src] = true;
        for(int nbr: adj[src]){
            size += dfs(nbr, visited);            
        }
        return size;
    }
}

class Solution {
    public long countPairs(int n, int[][] edges) {
        Graph g = new Graph(n);
        for(int[] edge: edges){
            g.addEdge(edge[0], edge[1]);
        }

        boolean[] visited = new boolean[n];
        long unreachableNodes = 0;
        for(int idx = 0; idx < n; idx++){
            if(visited[idx] == true) continue;
            long size = g.dfs(idx, visited);
            unreachableNodes += size * (n - size); 
        }

        return unreachableNodes/2l;
    }
}