//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;




class Array
 {
	public static void main (String[] args)
	 {
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-->0)
	    {
	    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++)
		    {
		        arr[i] = sc.nextInt();
		    }
		    int key = sc.nextInt();
		    Solution ob=new Solution();
		    int ar[]=ob.findIndex(arr,n,key);
		    System.out.println(ar[0]+" "+ar[1]);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    static int[] findIndex(int a[], int N, int key){ 
        
        int fi = firstIndex(a, 0, key);
        int li = lastIndex(a, N - 1, key);
        
        return new int[]{fi, li};
    }
    
    static int firstIndex(int[] arr, int idx, int key){
        if(idx == arr.length) return -1;
        if(arr[idx] == key) return idx;
        
        return firstIndex(arr, idx + 1, key);
    }
    
    static int lastIndex(int[] arr, int idx, int key){
        if(idx == -1) return -1; 
        if(arr[idx] == key) return idx;
        
        return lastIndex(arr, idx - 1, key);
    }
}