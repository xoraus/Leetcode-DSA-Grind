//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int numberOfItems, int knapsackCapacity, int itemCost[], int itemWeight[]) {
        int[][] memoization = new int[numberOfItems + 1][knapsackCapacity + 1];
        for (int i = 0; i <= numberOfItems; i++) {
            for (int j = 0; j <= knapsackCapacity; j++) {
                memoization[i][j] = -1;
            }
        }
        return memoize(0, knapsackCapacity, itemCost, itemWeight, numberOfItems, memoization);
    }
    
    static int memoize(int itemIndex, int knapsackCapacity, int itemCost[], int itemWeight[], int numberOfItems, int[][] memoization) {
        if (itemIndex == numberOfItems || knapsackCapacity == 0) return 0;
        
        if (memoization[itemIndex][knapsackCapacity] != -1) return memoization[itemIndex][knapsackCapacity];
    
        // Exclude the current item
        int exclude = memoize(itemIndex + 1, knapsackCapacity, itemCost, itemWeight, numberOfItems, memoization);
    
        // Include the current item if it fits in the knapsack
        int include = (knapsackCapacity >= itemWeight[itemIndex]) ? itemCost[itemIndex] + memoize(itemIndex, knapsackCapacity - itemWeight[itemIndex], itemCost, itemWeight, numberOfItems, memoization) : -1;
    
        return memoization[itemIndex][knapsackCapacity] = Math.max(include, exclude);
    }

}