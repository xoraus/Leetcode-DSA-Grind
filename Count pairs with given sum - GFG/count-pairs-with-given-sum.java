//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

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
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int getPairsCount(int[] A, int n, int B) {
    Arrays.sort(A);
    int i = 0; // Left pointer
    int j = A.length - 1; // Right pointer
    long ans = 0; // To store the result (as it can be large, using long)
    
    while (i < j) {
        if (A[i] + A[j] == B) {
            int curIdxP1 = i; // Temporary pointer for A[i]
            int currIdxP2 = j; // Temporary pointer for A[j]
            
            if (A[i] == A[j]) {
                // Equal elements A[i] and A[j]
                long cnt = j - i + 1; // Number of occurrences of A[i] and A[j]
                ans += (cnt * (cnt - 1) / 2); // Counting pairs with equal elements
                break;
            } else {
                // Different elements A[i] and A[j]
                // Count number of elements with value A[i]
                while (A[i] == A[curIdxP1]) {
                    curIdxP1++;
                }
                int cnt1 = curIdxP1 - i; // Number of occurrences of A[i]
                i = curIdxP1; // Move i to the next unique element
                
                // Count number of elements with value A[j]
                while (A[currIdxP2] == A[j]) {
                    currIdxP2--;
                }
                int cnt2 = j - currIdxP2; // Number of occurrences of A[j]
                j = currIdxP2; // Move j to the next unique element
                
                ans += (cnt1 * cnt2); // Counting pairs with different elements
            }
        } else if (A[i] + A[j] > B) {
            // Sum is greater than B, move j to the left to decrease the sum
            j--;
        } else {
            // Sum is less than B, move i to the right to increase the sum
            i++;
        }
    }
    return (int) ans; // Convert the final result back to int and return
    }
}
