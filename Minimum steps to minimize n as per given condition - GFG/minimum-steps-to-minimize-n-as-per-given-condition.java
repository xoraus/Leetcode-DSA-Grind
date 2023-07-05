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
                    System.out.println(ob.minSteps(n));
                    
                }
        }
}    
// } Driver Code Ends


class Solution {
    public int memoization(int N, int[] dp) {
        if (N == 1) return 0;
        if (dp[N] != -1) return dp[N];

        int reduceBy1 = memoization(N - 1, dp);
        int divBy2 = (N % 2 == 0) ? memoization(N / 2, dp) : Integer.MAX_VALUE;
        int divBy3 = (N % 3 == 0) ? memoization(N / 3, dp) : Integer.MAX_VALUE;

        return dp[N] = Math.min(reduceBy1, Math.min(divBy2, divBy3)) + 1;
    }

    public int minSteps(int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);

        return memoization(N, dp);
    }
}

