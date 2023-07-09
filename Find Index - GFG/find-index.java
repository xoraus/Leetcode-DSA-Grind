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
    static int[] search(int[] arr, int idx, int key) {
        if (idx == arr.length) 
        	return new int[] { -1, -1 };
        
        int[] ans = search(arr, idx + 1, key);
        
        if (arr[idx] == key) {
            if(ans[0] == -1){
            	ans[0] = ans[1] = idx;
            } else {
           		ans[0] = idx;
            }
            
        }
        return ans;
    }
    
    static int[] findIndex(int a[], int N, int key) {
        return search(a, 0, key);
    }
}