//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public static void merge(long array1[], long array2[], int lengthArray1, int lengthArray2) {
        // Total length of the merged array:
        int totalLength = lengthArray1 + lengthArray2;
    
        // Initial gap for comparisons:
        int gap = (totalLength / 2) + (totalLength % 2); // Use integer division to get the floor value
    
        while (gap > 0) {
            // Set up two pointers:
            int left = 0;
            int right = left + gap;
    
            while (right < totalLength) {
                // Case 1: Both pointers in array1[]:
                if (left < lengthArray1 && right < lengthArray1) {
                    swapIfGreater(array1, array1, left, right);
                }
    
                // Case 2: Both pointers in array2[]:
                else if (left >= lengthArray1) {
                    swapIfGreater(array2, array2, left - lengthArray1, right - lengthArray1);
                }
    
                // Case 3: Left pointer in array1[] and right pointer in array2[]:
                else {
                    swapIfGreater(array1, array2, left, right - lengthArray1);
                }
    
                left++;
                right++;
            }
            
            if(gap == 1) break;
    
            // Calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }
    }
    
    public static void swapIfGreater(long[] array1, long[] array2, int index1, int index2) {
        if (array1[index1] > array2[index2]) {
            long temp = array1[index1];
            array1[index1] = array2[index2];
            array2[index2] = temp;
        }
    }

}
