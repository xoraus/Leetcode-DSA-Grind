//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        int MOD = 1000000007;
        
        long[] count0 = new long[n + 1];
        long[] count1 = new long[n + 1];
        
        count0[1] = 1;
        count1[1] = 1;
        
        for (int idx = 2; idx <= n; idx++) {
            count0[idx] = (count0[idx - 1] + count1[idx - 1]) % MOD;
            count1[idx] = count0[idx - 1] % MOD;
        }
        
        return (count0[n] + count1[n]) % MOD;
    }
}
