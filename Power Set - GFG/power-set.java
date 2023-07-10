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
    public List<String> AllPossibleStrings(String str) {
        List<String> powerset = new ArrayList<>();
        powersetPost(str, 0, powerset);
        Collections.sort(powerset);
        powerset.remove("");
        return powerset;
    }
    
    public void powersetPost(String str, int idx, List<String> powerset) {
        if (idx == str.length()) {
            powerset.add("");
            return;
        }
    
        powersetPost(str, idx + 1, powerset);
    
        int n = powerset.size();
        for (int i = 0; i < n; i++) {
            String newSubset = str.charAt(idx) + powerset.get(i);
            powerset.add(newSubset);
        }
    }

}