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
            String a = sc.next ();
            String b = sc.next();
            Solution obj = new Solution();
    		System.out.println (obj.check (a, b));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   int check(String a, String b) {
        // Remove leading zeros
        a = removeLeadingZeros(a);
        b = removeLeadingZeros(b);
    
        // Compare lengths
        if (a.length() < b.length()) {
            return 1;
        } else if (a.length() > b.length()) {
            return 2;
        }
    
        // Compare individual characters
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) < b.charAt(i)) {
                return 1;
            } else if (a.charAt(i) > b.charAt(i)) {
                return 2;
            }
        }
    
        // If lengths are equal and characters are equal, strings are equal
        return 3;
    }
    
    private static String removeLeadingZeros(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        return str.substring(i);
    }
}
