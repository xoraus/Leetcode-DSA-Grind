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


class Solution { 
    public static boolean knows(int[][] M, int a, int b) {
        return M[a][b] == 1;
    }

    public static int celebrity(int[][] M, int N) {
        for (int i = 0; i < N; i++) {
            boolean isCelebrity = true;
            for (int j = 0; j < N; j++) {
                if (i != j && (knows(M, i, j) || !knows(M, j, i))) {
                    isCelebrity = false;
                    break;
                }
            }
            if (isCelebrity) {
                return i;
            }
        }
        return -1;
    }
}

