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
    public static int celebrity(int[][] M, int N) {
        Stack<Integer> stack = new Stack<>();
    
        for (int person = 0; person < N; person++) {
            stack.push(person);
        }
       
        while (stack.size() >= 2) {
            int personA = stack.pop();
            int personB = stack.pop();
    
            if (knows(M, personA, personB)) {
                stack.push(personB);
            } else {
                stack.push(personA);
            }
        }
    
        int potentialCelebrity = stack.pop();
    
        for (int i = 0; i < N; i++) {
            if (i != potentialCelebrity && (knows(M, potentialCelebrity, i) || !knows(M, i, potentialCelebrity))) {
                return -1;
            }
        }
    
        return potentialCelebrity;
    }
    
    public static boolean knows(int[][] M, int a, int b) {
        return M[a][b] == 1;
    } 
}