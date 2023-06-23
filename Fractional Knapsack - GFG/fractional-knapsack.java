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


// class Item {
//     int value, weight;

//     Item(int x, int y) {
//         this.value = x;
//         this.weight = y;
//     }
// }

class VByWComparator implements Comparator<Item> {
    public int compare(Item t, Item o) {
        double p1 = (t.value * 1.0) / t.weight;
        double p2 = (o.value * 1.0) / o.weight;

        if (p1 < p2)
            return +1;
        else if (p1 > p2)
            return -1;
        else
            return 0;
    }
}

class Solution {
    double fractionalKnapsack(int capacity, Item arr[], int n) {
        PriorityQueue<Item> pq = new PriorityQueue<>(new VByWComparator());
        for (int i = 0; i < n; i++)
            pq.add(arr[i]);

        double profit = 0.0;
        while (capacity > 0 && pq.size() > 0) {
            Item i = pq.remove();

            if (capacity > i.weight) {
                profit += i.value;
                capacity -= i.weight;
            } else {
                double currProfit = ((i.value * 1.0) / i.weight) * capacity;
                profit += currProfit;
                capacity = 0;
            }
        }

        return profit;
    }
}