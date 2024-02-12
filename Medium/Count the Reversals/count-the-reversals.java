//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String s){
        if (s.length() % 2 == 1) {
            return -1; // Cannot be balanced if the string length is odd.
        }
    
        int openCount = 0;
        int closeCount = 0;
    
        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                openCount++;
            } else {
                if (openCount > 0) {
                    openCount--;
                } else {
                    closeCount++;
                }
            }
        }
    
        int totalReversals = openCount + closeCount;
    
        return totalReversals / 2 + (openCount % 2);
    }
}