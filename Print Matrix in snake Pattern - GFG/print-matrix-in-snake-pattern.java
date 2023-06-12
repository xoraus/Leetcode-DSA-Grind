//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.snakePattern(matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> res = new ArrayList<>();
        
        // top to down row by row
        for(int row = 0; row < matrix.length; row++){
            if(row % 2 == 0) {
                // even row -> left to right
                for(int col = 0; col < matrix[0].length; col++){
                    res.add(matrix[row][col]);
                }    
            } else {
                // odd row -> right to left
                for(int col = matrix[0].length - 1; col >= 0; col--) {
                    res.add(matrix[row][col]);
                }   
            }
        }   
        return res;
    }
}