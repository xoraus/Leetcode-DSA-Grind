//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution {
    void calculateSubsetSums(ArrayList<Integer> nums, int currIdx, int currSum, ArrayList<Integer> subsetSums) {
        if (currIdx == nums.size()) {
            subsetSums.add(currSum);
            return;
        }
        
        // Include the current element
        calculateSubsetSums(nums, currIdx + 1, currSum + nums.get(currIdx), subsetSums);
        
        // Exclude the current element
        calculateSubsetSums(nums, currIdx + 1, currSum, subsetSums);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> nums, int size) {
        ArrayList<Integer> subsetSums = new ArrayList<>();
        calculateSubsetSums(nums, 0, 0, subsetSums);
        Collections.sort(subsetSums);
        return subsetSums;
    }
}
