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
    static int memo(int[] weight, int[] cost, int capacity, int item, int[][] dp) {
        if (item == cost.length) {
            return 0;
        }
        if (dp[capacity][item] != -1) {
            return dp[capacity][item];
        }

        int yes = (capacity >= weight[item]) ? memo(weight, cost, capacity - weight[item], item + 1, dp) + cost[item] : -1;
        int no = memo(weight, cost, capacity, item + 1, dp);

        return dp[capacity][item] = Math.max(yes, no);
    }

    static int knapSack(int capacity, int[] weight, int[] cost, int n) {
        int[][] dp = new int[capacity + 1][n + 1];

        for (int i = 0; i <= capacity; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return memo(weight, cost, capacity, 0, dp); 
    }
}


