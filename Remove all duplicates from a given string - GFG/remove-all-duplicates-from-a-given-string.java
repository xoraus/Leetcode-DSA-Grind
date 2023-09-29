//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    String removeDuplicates(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>(); // Use LinkedHashSet here
        
        // Iterate through the characters of the input string and add them to the set
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        
        // Create a StringBuilder to build the result string
        StringBuilder res = new StringBuilder();
        
        // Iterate through the set to construct the result string
        for (char ch : set) {
            res.append(ch);
        }
        
        // Convert the StringBuilder to a string and return it
        return res.toString();
    }


}

