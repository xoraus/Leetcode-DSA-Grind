class Solution {
    public void swap(char[] arr, int left, int right){
        char tempVal = arr[left];
        arr[left] = arr[right];
        arr[right] = tempVal;
    }
    public void reverseString(char[] arr) {
        int left = 0, right = arr.length - 1;

        while(left < right){
            swap(arr, left, right);
            left++;
            right--;
        }
    }
}