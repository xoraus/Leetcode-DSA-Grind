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
class Solution
{
    char firstRep(String str) {
        int[] freq = new int[26];
        
        // Fill the Frequency Array
        for(char ch: str.toCharArray()){
            freq[ch - 'a']++;
        }
        
        // Find the First Unique Non Repeating or Distinct Character
        for(char ch: str.toCharArray()){
            if(freq[ch - 'a'] > 1) return ch;
        }
        
        return '#';
    }
}