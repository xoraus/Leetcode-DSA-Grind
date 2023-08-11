//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            
            Solution g = new Solution();
            long ans = g.wineSelling(arr,N);
            
            System.out.println(ans);
            T--;
        }
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution {
    public long wineSelling(int[] arr, int N) {
        long work = 0L;
        int buy = 0, sell = 0;
    
        while (true) {
            while (buy < N && arr[buy] <= 0) {
                buy++;
            }
            while (sell < N && arr[sell] >= 0) {
                sell++;
            }
    
            if (buy == N || sell == N) {
                break;
            }
    
            int winesToSell = Math.min(-arr[sell], arr[buy]);
            int distance = Math.abs(sell - buy);
            work += (long) winesToSell * distance;
    
            arr[sell] += winesToSell;
            arr[buy] -= winesToSell;
        }
    
        return work;
    }

}

//{ Driver Code Starts.
// } Driver Code Ends