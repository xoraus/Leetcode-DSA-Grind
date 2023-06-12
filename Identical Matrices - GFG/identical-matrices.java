//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            int Grid1[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < N; j++)
                    Grid1[i][j] = Integer.parseInt(s[j]);
            }
            int Grid2[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < N; j++)
                    Grid2[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.areMatricesIdentical(N, Grid1, Grid2));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int areMatricesIdentical(int N, int[][] Grid1, int[][] Grid2) {
        
        if(Grid1.length != Grid2.length){
            return 0; // rows are not equal
        }
        
        if(Grid1[0].length != Grid2.length){
            return 0; // cols are not equal
        }
        
        // value comparison
        for(int row = 0; row < Grid1.length; row++){
            for(int col = 0; col < Grid1[0].length; col++){
                if(Grid1[row][col] != Grid2[row][col]){
                    return 0;
                }
            }
        }
        return 1;
    }
}