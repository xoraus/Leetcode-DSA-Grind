//{ Driver Code Starts
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
            System.out.println(ob.numberOfWays(N));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of ways to tile a 2 x W floor
    // using 2 x 1 tiles
    static Long numberOfWays(int W) {
        // Initialize a memoization array to store results for subproblems
        Long[] dp = new Long[W + 1];
        Arrays.fill(dp, -1L); // Fill the array with -1 to indicate uncomputed values

        // Call the tiling function to compute the number of ways
        return tiling(W, dp) % 1000000007;
    }

    // Recursive function to find the number of ways to tile a 2 x n floor
    // using 2 x 1 tiles
    public static Long tiling(int n, Long[] dp) {
        // Base cases
        if (n == 1) return 1L;
        if (n == 2) return 2L;

        // If the result is already computed, return it from the memoization array
        if (dp[n] != -1L) return dp[n];

        // Calculate the number of ways by considering both vertical and horizontal placement
        Long ans = (tiling(n - 1, dp) + tiling(n - 2, dp)) % 1000000007;

        // Store the result in the memoization array and return it
        dp[n] = ans;
        return ans;
    }
};
    