//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.getCount(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution {
	int[][] adjacencyList = {
        {0, 8},
        {1, 2, 4},
        {1, 2, 3, 5},
        {2, 3, 6},
        {1, 4, 5, 7},
        {2, 4, 5, 6, 8},
        {3, 5, 6, 9},
        {4, 7, 8},
        {0, 5, 7, 8, 9},
        {6, 8, 9}
    };
    
    public long countCombinations(int lastKey, int remainingKeys, long[][] memoizationTable) {
        if (remainingKeys == 0) return 1L;
        if (memoizationTable[lastKey][remainingKeys] != -1L) return memoizationTable[lastKey][remainingKeys];
    
        long combinations = 0;
        
        for (int neighbor : adjacencyList[lastKey]) {
            combinations += countCombinations(neighbor, remainingKeys - 1, memoizationTable);
        }
    
        return memoizationTable[lastKey][remainingKeys] = combinations;
    }
    
    public long getCount(int N) {
        long[][] memoizationTable = new long[10][N];
        
        // Initialize memoizationTable with -1
        for (int i = 0; i < 10; i++) {
            Arrays.fill(memoizationTable[i], -1);
        }
    
        long totalCombinations = 0;
        for (int startingKey = 0; startingKey < 10; startingKey++) {
            totalCombinations += countCombinations(startingKey, N - 1, memoizationTable);
        }
    
        return totalCombinations;
    }
}