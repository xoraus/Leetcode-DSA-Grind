class Solution {
    List<List<Integer>> paths = new ArrayList<>();
    
    public void allPaths(int src, int dest, int[][] graph, List<Integer> path){
        path.add(src);

        if(src == dest){
            paths.add(new ArrayList<>(path));
        }

        for(int nbr: graph[src]){
            allPaths(nbr, dest, graph, path);
        }

        path.remove(path.size() - 1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        allPaths(0, n - 1, graph, new ArrayList<>());
        return paths;
    }
}

