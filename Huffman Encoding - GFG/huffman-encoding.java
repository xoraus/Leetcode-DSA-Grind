//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
		    int[] f = new int[N];
		    for(int i = 0; i < N; i++){
		        f[i] = Integer.parseInt(element[i]);
		    }
            ArrayList<String> res  = ob.huffmanCodes(S,f,N);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Node implements Comparable<Node> {
    char character = '#';
    int frequency;
    Node leftChild, rightChild;

    public Node() {}

    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public int compareTo(Node other) {
        if (this.frequency < other.frequency) return -1;
        return +1;
    }
}

class Solution {
    public void preorder(Node root, String path, ArrayList<String> encodings) {
        if (root.character != '#') {
            encodings.add(path);
            return;
        }

        preorder(root.leftChild, path + "0", encodings);
        preorder(root.rightChild, path + "1", encodings);
    }

    public ArrayList<String> huffmanCodes(String str, int[] frequencies, int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int idx = 0; idx < N; idx++) {
            pq.add(new Node(str.charAt(idx), frequencies[idx]));
        }

        while (pq.size() > 1) {
            Node root = new Node();
            root.leftChild = pq.remove();
            root.rightChild = pq.remove();
            root.frequency = root.leftChild.frequency + root.rightChild.frequency;
            pq.add(root);
        }

        Node root = pq.remove();

        ArrayList<String> encodings = new ArrayList<>();
        preorder(root, "", encodings);
        return encodings;
    }
}

