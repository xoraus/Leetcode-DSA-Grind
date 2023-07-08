//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    static int knapSack(int capacity, int[] weight, int[] cost, int n) {
        int[][] dp = new int[capacity + 1][cost.length + 1];
        for (int item = 1; item <= cost.length; item++) {
            for (int cap = 1; cap <= capacity; cap++) {
                int no = dp[cap][item - 1];
                int yes = (cap >= weight[item - 1]) ? cost[item - 1] + dp[cap - weight[item - 1]][item - 1] : -1;
                dp[cap][item] = Math.max(yes, no);
            }
        }
        return dp[capacity][cost.length];
    }
}


