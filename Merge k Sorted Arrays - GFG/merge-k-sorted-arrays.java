//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java
class ArrayContainer {
    int value;
    int arrayIndex;
    int elementIndex;
    
    public ArrayContainer(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

class Solution {
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Create a min-heap to keep track of the smallest elements from each array
        PriorityQueue<ArrayContainer> minHeap = new PriorityQueue<>(Comparator.comparingInt(ac -> ac.value));
        
        // Initialize the heap with the first element from each array
        for (int i = 0; i < K; i++) {
            if (arr[i].length > 0) {
                minHeap.add(new ArrayContainer(arr[i][0], i, 0));
            }
        }
        
        while (!minHeap.isEmpty()) {
            ArrayContainer min = minHeap.poll();
            result.add(min.value);
            
            int arrayIndex = min.arrayIndex;
            int elementIndex = min.elementIndex + 1;
            
            if (elementIndex < arr[arrayIndex].length) {
                minHeap.add(new ArrayContainer(arr[arrayIndex][elementIndex], arrayIndex, elementIndex));
            }
        }
        
        return result;
    }
}