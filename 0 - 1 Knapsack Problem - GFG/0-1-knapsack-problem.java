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
    static int helper(int capacity, int item, int[] weight, int[] cost, int[][] dp) {
        if (item == cost.length) {
            return 0;
        }
        if (dp[capacity][item] != -1) {
            return dp[capacity][item];
        }

        int pickItem = (capacity >= weight[item]) ? helper(capacity - weight[item], item + 1, weight, cost, dp) + cost[item] : -1;
        int skipItem = helper(capacity, item + 1, weight, cost, dp);

        return dp[capacity][item] = Math.max(pickItem, skipItem);
    }

    static int knapSack(int capacity, int[] weight, int[] cost, int n) {
        int[][] dp = new int[capacity + 1][n + 1];

        for (int i = 0; i <= capacity; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(capacity, 0, weight, cost, dp); 
    }
}


