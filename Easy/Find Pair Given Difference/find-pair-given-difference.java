//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean findPair(int nums[], int size, int target){
        Arrays.sort(nums);
        
        int left = 0, right = 1, count = 0;
        while (left < nums.length && right < nums.length) {
            if (left > 0 && nums[left - 1] == nums[left]) {
                left++;
                continue;
            }
            if (left == right) {
                right++;
                continue;
            }

            int diff = nums[right] - nums[left];

            if (diff == target) {
                count++;
                left++;
            } else if (diff < target) {
                right++;
            } else {
                left++;
            }
        }

        return count > 0;
        
    }
}