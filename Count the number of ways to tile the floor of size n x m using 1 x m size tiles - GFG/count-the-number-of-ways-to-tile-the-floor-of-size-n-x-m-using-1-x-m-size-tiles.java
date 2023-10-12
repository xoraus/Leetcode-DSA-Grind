//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String [] S = s.split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.countWays(n, m);
            System.out.println(ans);         
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int countWays(int floorLength, int tileWidth) {
        int mod = 1000000007;
        int[] waysToTile = new int[floorLength + 1];
        
        // Initialize base cases
        for (int i = 1; i <= floorLength; i++) {
            if (i < tileWidth) {
                waysToTile[i] = 1;
            } else if (i == tileWidth) {
                waysToTile[i] = 2;
            } else {
                waysToTile[i] = (waysToTile[i - 1] + waysToTile[i - tileWidth]) % mod;
            }
        }
        
        return waysToTile[floorLength];
    }

}