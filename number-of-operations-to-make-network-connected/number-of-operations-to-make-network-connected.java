class Graph {
    public int n;
    public ArrayList<Integer>[] adj;

    public Graph(int n) {
        this.n = n;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
    }

    // unweighted, undirected
    public void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }

    public void dfs(int src, boolean[] vis) {
        if (vis[src] == true)
            return;
        vis[src] = true;
        for (int nbr : adj[src])
            dfs(nbr, vis);
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n - 1 > connections.length) return -1;

        Graph g = new Graph(n);
        for(int[] edge: connections){
            g.addEdge(edge[0], edge[1]);
        }

        boolean[] visited = new boolean[n];
        int minStepForConnection = 0;

        for(int idx = 0; idx < n; idx++){
            if(visited[idx] == true) continue;
            minStepForConnection++;
            g.dfs(idx, visited);
        }
        
        return minStepForConnection - 1;
    }
}