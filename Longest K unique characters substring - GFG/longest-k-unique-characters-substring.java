//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String str, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxLen = 0, left = 0;
    
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    
            while (freq.size() > k) {
                char chl = str.charAt(left);
                freq.put(chl, freq.getOrDefault(chl, 0) - 1);
    
                if (freq.get(chl) == 0) {
                    freq.remove(chl);
                }
                left++;
            }
            if(freq.size() == k){
                maxLen = Math.max(maxLen, right - left + 1);    
            }
        }
        if(maxLen == 0) return -1;
        return maxLen;
    }
}