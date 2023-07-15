//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static ArrayList<String> paths; 
    
    public static void findPaths(int[][] mat, int row, int col, String path){
        if(row < 0 || row == mat.length || col < 0 || col == mat[0].length) return;
        if(mat[row][col] == 0 || mat[row][col] == -1) return;
        
        if(row == mat.length - 1 && col == mat[0].length - 1){
            paths.add(path);
            return;
        }
        
        mat[row][col] = -1;
        
        findPaths(mat, row - 1, col, path + "U");
        findPaths(mat, row + 1, col, path + "D");
        findPaths(mat, row, col - 1, path + "L");
        findPaths(mat, row, col + 1, path + "R");
        
        mat[row][col] = 1;
    }
    public static ArrayList<String> findPath(int[][] mat, int n) {
        paths = new ArrayList<>();
        findPaths(mat, 0, 0, "");
        return paths;
    }
}