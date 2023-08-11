class Solution {
    public int partition(int[] arr, int left, int right) {
        int j = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[right]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        int temp = arr[j];
        arr[j] = arr[right];
        arr[right] = temp;
        return j;
    }

    public int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }
        
        int pivot = partition(arr, left, right);
        
        if (pivot == arr.length - k) {
            return arr[pivot];
        } else if (pivot > arr.length - k) {
            return quickSelect(arr, left, pivot - 1, k);
        } else {
            return quickSelect(arr, pivot + 1, right, k);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
}