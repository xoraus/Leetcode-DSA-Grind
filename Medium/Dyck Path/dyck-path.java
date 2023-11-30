//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.dyckPaths(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static Long dyckPaths(int n) {
        return NthCatalan(n);
    }

    public static Long NthCatalan(int n) {
        Long[] dp = new Long[n + 1];
        dp[0] = dp[1] = 1L;

        for (int i = 2; i <= n; i++) {
            dp[i] = 0L;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
};