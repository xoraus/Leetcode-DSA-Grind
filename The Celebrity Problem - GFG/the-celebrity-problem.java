//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
    	int ans = 0;
        for (int idx = 1; idx < n; idx++) {
            if (M[idx][ans] == 0) {
                ans = idx;
            }
        }
    
        for (int i = 0; i < n; i++) {
            if (i == ans)
                continue;
            if (M[ans][i] != 0)
                return -1;
            if (M[i][ans] != 1)
                return -1;
        }
        return ans;
    }
}