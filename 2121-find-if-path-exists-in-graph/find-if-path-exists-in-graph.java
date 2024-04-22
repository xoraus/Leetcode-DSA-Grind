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

    public boolean hasPathBFS(int src, int dest) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        boolean[] vis = new boolean[n];
        
        while (!q.isEmpty()) {
            src = q.remove();
            
            if (src == dest) {
                return true;
            }
            
            if (vis[src]) {
                continue;
            }
            
            vis[src] = true;
            
            for (Integer nbr : adj[src]) {
                q.add(nbr);
            }
        }
        
        return false;
    }
}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph graph = new Graph(n);    
        for(int[] edge: edges){
            graph.addEdge(edge[0], edge[1]);
        }
        return graph.hasPathBFS(source, destination);
    }
}