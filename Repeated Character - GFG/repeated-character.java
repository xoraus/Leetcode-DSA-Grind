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
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            char res = ob.firstRep(s);
            if (res == '#')
                System.out.println(-1);
            else
                System.out.println(res);
             
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    char firstRep(String str) {
        int[] freq = new int[26];
        char repeating = '#';
        
        for(int idx = str.length() - 1; idx >= 0; idx--){
        	char ch = str.charAt(idx);
        	freq[ch - 'a']++;
        	if(freq[ch - 'a'] > 1) repeating = ch;
        }
        
        return repeating;
    }
}