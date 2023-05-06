//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().maxRepeating(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    int maxRepeating(int[] nums, int n, int k) {
        // Visited Mark
        for(int i=0; i<n; i++){
            int val = nums[i] % (n+1);
            nums[val] += (n+1);
        }
        
        // Finding Max Frequency Value
        int maxFreq = 0, value = 0;
        for(int i=0; i<n; i++){
            int freq = nums[i] / (n+1);
            if(freq > maxFreq){
                maxFreq = freq;
                value = i;
            }
        }
        return value;
    }
}