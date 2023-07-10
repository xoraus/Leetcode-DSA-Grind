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

    public boolean hasPath(int src, int dest, boolean[] visited){
        if(src == dest) return true;
        if(visited[src] == true) return false;

        visited[src] = true;
        for(int nbr: adj[src]){
            if(hasPath(nbr, dest, visited)){
                return true;
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
        boolean[] visited = new boolean[n];
        return graph.hasPath(source, destination, visited);
    }
}