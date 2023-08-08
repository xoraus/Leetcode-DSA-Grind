//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);
            
            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int prefixCount = 0;
        int wordCount = 0;

        public TrieNode getChild(char ch) {
            return children[ch - 'a'];
        }

        public void setChild(char ch) {
            children[ch - 'a'] = new TrieNode();
        }
    }
    
    public String[] findPrefixes(String[] words, int N) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insertWord(root, word);
        }

        String[] result = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = findShortestUniquePrefix(root, words[i]);
        }
        return result;
    }

    public void insertWord(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (root.getChild(ch) == null) {
                root.setChild(ch);
            }

            root.prefixCount++;
            root = root.getChild(ch);
        }

        root.prefixCount++;
        root.wordCount++;
    }

    public String findShortestUniquePrefix(TrieNode root, String word) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (root.prefixCount == 1) {
                return word.substring(0, i);
            }

            root = root.getChild(ch);
        }

        return word;
    }
}
 