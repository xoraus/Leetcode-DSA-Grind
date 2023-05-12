class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int idx = 0;

        // Increasig Part 
        while(idx + 1 < arr.length){
            if(arr[idx] == arr[idx + 1]){
                return false; // not strictly increasing
            } else if(arr[idx] > arr[idx + 1]){
                break;
            }
            idx++;
        }

        if(idx == 0){
            return false; // no increasing part
        }

        if(idx == arr.length - 1){
            return false; // no decreasing part
        }

        while(idx + 1 < arr.length){
            if(arr[idx] == arr[idx + 1]){
                break;
            } else if(arr[idx] < arr[idx + 1]) {
                break;
            }
            idx++;
        }
        
        return (idx == arr.length - 1);
    }
}