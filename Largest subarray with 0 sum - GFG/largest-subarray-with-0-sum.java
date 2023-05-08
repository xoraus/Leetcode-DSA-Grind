//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n){
        HashMap<Long, Integer> map = new HashMap<>();
        // Key: Prefix Sum, Value: Leftmost Index
        
        map.put(0l, -1); // Empty Subarray
        int maxlength = 0;
        long sum = 0;
        
        for(int i=0; i<n; i++){
            sum += arr[i];
            
            int lastSeenAtIndex = map.getOrDefault(sum, i);
            maxlength = Math.max(maxlength, i - lastSeenAtIndex);
            map.putIfAbsent(sum, i);
        }
        return maxlength;
    }
}