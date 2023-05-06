//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int nums[], int n) {
        // Pass 1: Mark Visited
        for(int i=0; i<n; i++){
            int val = nums[i] % (n+1);
            nums[val] += (n+1);
        }

        ArrayList<Integer> repeating = new ArrayList<>();

        // Pass 2: Find Dumplicates
        for(int i=0; i<n; i++){
            int freq = nums[i] / (n+1);
            if(freq > 1) repeating.add(i);
        }
        
        if(repeating.size() == 0) repeating.add(-1);
        return repeating;
    }
}
