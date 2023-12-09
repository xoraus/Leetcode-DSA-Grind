//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution {
    double fractionalKnapsack(int capacity, Item[] items, int n) {
        PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingDouble(item ->
                -1.0 * item.value / item.weight));
        
        for (int i = 0; i < n; i++)
            pq.add(items[i]);

        double totalProfit = 0.0;

        while (capacity > 0 && !pq.isEmpty()) {
            Item currentItem = pq.remove();
            double ratio = (double) currentItem.value / currentItem.weight;
            
            totalProfit += Math.min(capacity, currentItem.weight) * ratio;
            capacity -= currentItem.weight;
        }

        return totalProfit;
    }
}
