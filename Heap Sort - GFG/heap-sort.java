//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends


class Solution {
    
    public void heapSort(int[] arr, int n) {
        // Build the max heap by calling downheapify on non-leaf nodes
        for (int i = n - 1; i >= 0; i--)
            downHeapify(arr, n, i);

        // Extract elements from the heap one by one and place them at the end
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            // Call downheapify on the reduced heap
            downHeapify(arr, i, 0);
        }
    }
    
    // Perform downheapify operation on a subtree rooted at idx
    void downHeapify(int[] arr, int n, int idx) {
        int leftChildIndex = 2 * idx + 1;
        int rightChildIndex = 2 * idx + 2;

        int largestIndex = idx;
        if (leftChildIndex < n && arr[leftChildIndex] > arr[largestIndex])
            largestIndex = leftChildIndex;
        if (rightChildIndex < n && arr[rightChildIndex] > arr[largestIndex])
            largestIndex = rightChildIndex;

        // If the largest element is not at the current index, swap and continue downheapify
        if (largestIndex != idx) {
            swap(arr, idx, largestIndex);
            downHeapify(arr, n, largestIndex);
        }
    }
    
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 }
 
 
