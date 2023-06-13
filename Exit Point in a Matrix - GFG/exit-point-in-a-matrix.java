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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().split(" ");
                for(int j = 0; j < m; j++){
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(matrix);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // direction 0 -> right, 1 -> down, 2 -> left, 3 -> top
    public int[] FindExitPoint(int[][] mat) {
        int row = 0, col = 0, direction = 0;
        while (row >= 0 && col >= 0 && row < mat.length && col < mat[0].length) {
            if (mat[row][col] == 1) {
                mat[row][col] = 0; // set 1 to 0
                direction = (direction + 1) % 4; // rotate the direction
            }
            if (direction == 0) {
                // right
                col++;
            } else if (direction == 1) {
                // down
                row++;
            } else if (direction == 2) {
                // left
                col--;
            } else {
                // top
                row--;
            }
        }
        if (row < 0) {
            // top wall
            return new int[]{row + 1, col};
        } else if (col < 0) {
            // left wall
            return new int[]{row, col + 1};
        } else if (row >= mat.length) {
            // bottom wall
            return new int[]{row - 1, col};
        } else {
            // right wall
            return new int[]{row, col - 1};
        }
    }

}