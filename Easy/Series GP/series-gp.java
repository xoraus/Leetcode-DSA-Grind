//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s1 = br.readLine().trim();
            String[] s2 = s1.split(" ");
            int a = Integer.parseInt(s2[0]);
            int r = Integer.parseInt(s2[1]);
            int n = Integer.parseInt(s2[2]);
            Solution ob = new Solution();
            int ans = ob.Nth_term(a, r, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    private static final int MODULO = 1000000007;
    
    public int Nth_term(int initialTerm, int commonRatio, int termNumber){
        long result = (long) initialTerm * calculatePower(commonRatio, termNumber - 1) % MODULO;
        return (int) result;
    }
    
    private long calculatePower(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        long temp = calculatePower(base, exponent / 2) % MODULO;
        temp = (temp * temp) % MODULO;

        if (exponent % 2 == 0) {
            return temp % MODULO;
        }

        return (base * temp) % MODULO;
    }
}