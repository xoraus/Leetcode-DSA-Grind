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
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().minRemoval(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    public static int upperBound(int[] nums, int target) {
        // Same as Ceil Value
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }

    int minRemoval(int arr[], int n) {
        Arrays.sort(arr);

        int minRemoval = n;

        for (int idx = 0; idx < n; idx++) {
            int leftDel = idx;
            int rightDel = n - upperBound(arr, 2 * arr[idx]);

            minRemoval = Math.min(minRemoval, leftDel + rightDel);
        }

        return minRemoval;
    }
}