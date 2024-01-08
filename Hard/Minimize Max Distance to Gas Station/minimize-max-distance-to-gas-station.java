//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int k = sc.nextInt();
      Solution obj = new Solution();
      double ans = obj.findSmallestMaxDist(a,k);
      System.out.printf("%.2f",ans);
      System.out.println();
    }
  }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
      public static double findSmallestMaxDist(int[] sections, int availableGasStations) {
        int n = sections.length; // Size of the array
        double lowerBound = 0;
        double upperBound = 0;
    
        // Find the maximum distance between sections:
        for (int i = 0; i < n - 1; i++) {
            upperBound = Math.max(upperBound, (double) (sections[i + 1] - sections[i]));
        }
    
        // Apply Binary search:
        double epsilon = 1e-6;
        while (upperBound - lowerBound > epsilon) {
            double mid = (lowerBound + upperBound) / 2.0;
            int gasStationsNeeded = calculateGasStationsNeeded(mid, sections);
            
            if (gasStationsNeeded > availableGasStations) {
                lowerBound = mid;
            } else {
                upperBound = mid;
            }
        }
        
        return upperBound;
    }
    
    public static int calculateGasStationsNeeded(double distance, int[] sections) {
        int n = sections.length; // Size of the array
        int gasStationsCount = 0;
        
        for (int i = 1; i < n; i++) {
            int sectionsInBetween = (int) ((sections[i] - sections[i - 1]) / distance);
            
            if ((sections[i] - sections[i - 1]) == (distance * sectionsInBetween)) {
                sectionsInBetween--;
            }
            
            gasStationsCount += sectionsInBetween;
        }
        
        return gasStationsCount;
    }
     
}
     