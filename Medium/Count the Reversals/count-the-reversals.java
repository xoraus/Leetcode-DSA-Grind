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
    int countRev(String s) {
       // Check if the string length is odd, which means it can't be balanced.
        if (s.length() % 2 == 1) {
            return -1;
        }
    
        int openCount = 0;  // Count of open curly brackets '{'.
        int closeCount = 0; // Count of close curly brackets '}'.
    
        // Iterate through each character in the string.
        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                openCount++; // Increment open count for '{'.
            } else {
                // If there are open brackets to match, decrement open count.
                if (openCount > 0) {
                    openCount--;
                } else {
                    closeCount++; // No matching open bracket, so increment close count.
                }
            }
        }
    
        int totalReversals = openCount + closeCount; // Total reversals needed.
        
        // If there are unmatched open brackets, add 1 to the total reversals.
        if (openCount % 2 == 1) {
            return totalReversals / 2 + 1;
        }
    
        return totalReversals / 2;
    } 
}

