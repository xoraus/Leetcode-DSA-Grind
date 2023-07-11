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
    }

    public void dfs(int src, boolean[] visited){
        if(visited[src] == true) return;

        visited[src] = true;
        for(int nbr: adj[src]){
            dfs(nbr, visited);
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Graph g = new Graph(n);

        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(row != col && isConnected[row][col] == 1){
                    g.addEdge(row, col);
                }
            }
        }    
        
        boolean[] visited = new boolean[n];
        int numberOfProvinces = 0;

        for(int idx = 0; idx < n; idx++){
            if(visited[idx] == true) continue;
            g.dfs(idx, visited);
            numberOfProvinces++;
        }

        return numberOfProvinces;
    }
}