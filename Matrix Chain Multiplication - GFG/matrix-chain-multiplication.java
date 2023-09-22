//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int nums[]) {
        int[][] dp = new int[N][N];
    
        for (int gap = 1; gap < N - 1; gap++) {
            for (int l = 0, r = gap; r < N - 1; l++, r++) {
    
                int minCost = Integer.MAX_VALUE;
                // Creating partitions
                for (int k = l; k < r; k++) {
                    // Left Matrices -> Multiplication Min Cost
                    int left = dp[l][k];
                    // Right Matrices -> Multiplication Min Cost
                    int right = dp[k + 1][r];
                    // Left * Right Multiplication Cost
                    int cost = left + (nums[l] * nums[k + 1] * nums[r + 1]) + right;
                    minCost = Math.min(minCost, cost);
                }
    
                dp[l][r] = minCost;
            }
        }
        return dp[0][N - 2];
    }
}