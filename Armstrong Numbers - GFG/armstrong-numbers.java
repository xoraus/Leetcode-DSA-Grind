//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static String armstrongNumber(int num) {
        if (num < 100 || num > 999) {
            return "No"; // Not a 3-digit number
        }
        
        int originalNum = num;
        int sumOfCubes = 0;
        
        while (num > 0) {
            int digit = num % 10;
            sumOfCubes += digit * digit * digit;
            num /= 10;
        }
        
        if (sumOfCubes == originalNum) {
            return "Yes"; // It's an Armstrong number
        } else {
            return "No"; // It's not an Armstrong number
        }
    }
}