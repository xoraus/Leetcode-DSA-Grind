//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.countFactors(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int countFactors(int num) {
        int count = 0;
   
        for(int i = 1; i * i <= num; i++){
            if(num % i == 0){
                if(num / i == i) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}