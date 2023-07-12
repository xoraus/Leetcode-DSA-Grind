//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends

class Graph {
    public int n;
    public ArrayList<Integer>[] adj;

    @SuppressWarnings("all")
    public Graph(int n) {
        this.n = n;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
    }

    // unweighted, undirected
    public void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    public int dfs(int src, boolean[] vis) {
        if (vis[src] == true)
            return 0;
        vis[src] = true;
        int size = 1;
        for (int nbr : adj[src])
            size += dfs(nbr, vis);
        return size;
    }
}


class Solution {
    public int minSwaps(int nums[]) {
        int n = nums.length;
        
        HashMap<Integer, Integer> oldIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            oldIdx.put(nums[i], i);
        }
        
        Arrays.sort(nums);
        
        Graph g = new Graph(n);
        for (int i = 0; i < n; i++) {
            int j = oldIdx.get(nums[i]);
            g.addEdge(i, j);
        }
        
        int minSwaps = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i])
                continue;
            int size = g.dfs(i, vis);
            minSwaps += (size - 1);
        }
        
        return minSwaps;
        
    }
}