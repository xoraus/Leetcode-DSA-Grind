//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
     public int twoSum(int[] nums, int left, int right, int target) {
        int count = 0;
        while(left < right){
            int sum = nums[left] + nums[right];
            
            if(sum == target){
                count++;
                left++; right--;
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int count = 0;
        
        for(int lastElement=arr.length-1;lastElement>=0;lastElement--){
            count += twoSum(arr, 0, lastElement - 1, arr[lastElement]);
        }
        return count;
    }
}