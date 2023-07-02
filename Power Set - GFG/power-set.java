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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> subsets(String input, int idx, String output, List<String> subsets){
        if(idx == input.length()){
            if(output.length() > 0) subsets.add(output);
            return subsets;
        }
        
        // yes choice
        subsets(input, idx + 1, output + input.charAt(idx), subsets);
        
        // no choice
        subsets(input, idx + 1, output, subsets);
        
        return subsets;
    }
    
    public List<String> AllPossibleStrings(String input){
        List<String> subsets = new ArrayList<>();
        subsets(input, 0, "", subsets);
        Collections.sort(subsets);
        return subsets;
    }
}