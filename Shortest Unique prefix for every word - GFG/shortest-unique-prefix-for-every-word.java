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

    public void insertWord(TrieNode root, String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (current.getChild(ch) == null) {
                current.setChild(ch);
            }

            current.prefixCount++;
            current = current.getChild(ch);
        }

        current.prefixCount++;
        current.wordCount++;
    }

    public String findShortestUniquePrefix(TrieNode root, String word) {
        TrieNode current = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (current.prefixCount == 1) {
                return prefix.toString();
            }

            prefix.append(ch);
            current = current.getChild(ch);
        }

        return word;
    }

    public String[] findPrefixes(String[] words, int n) {
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
}
