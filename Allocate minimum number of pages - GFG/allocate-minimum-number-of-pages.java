//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    // Can I Distribute all books to the totalStudents within maximum load
    public static boolean isPossible(int[] pages, int maxLoad, int totalStud) {
        int requiredStud = 1, currentLoad = 0;

        for (int book : pages) {
            if (currentLoad + book <= maxLoad) {
                currentLoad += book;
            } else {
                requiredStud++;
                currentLoad = book;
            }
        }

        return (requiredStud <= totalStud);
    }

    public static int maxOfArray(int[] pages) {
        int max = 0;
        for (int book : pages)
            max = Math.max(max, book);
        return max;
    }

    public static int sumOfArray(int[] pages) {
        int sum = 0;
        for (int book : pages)
            sum += book;
        return sum;
    }

    public static int findPages(int[] pages, int books, int stud) {
        if (books < stud)
            return -1; // some students will not get any book

        int left = maxOfArray(pages); // Someone will have to read the max pages book
        int right = sumOfArray(pages); // Someone might have to read all the books

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(pages, mid, stud) == true)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
};