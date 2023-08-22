class Solution {
    public int calcInv(int[] arr, int left, int mid, int right){
        int invCount = 0;
        int idx1 = left, idx2 = mid+1, idx3 = 0;
        while(idx1<=mid && idx2<=right){
            if(arr[idx1]<=2l * arr[idx2]){
                idx1++;
                idx3++;
            } else {
                invCount += (mid-idx1+1);
                idx2++;
                idx3++;
            }
        }
        return invCount; 
    }
    public void merge(int[] arr, int left, int mid, int right){
        int[] res = new int[right-left+1];
        int idx1 = left, idx2 = mid+1, idx3 = 0;
        while (idx1 <= mid && idx2 <= right) {
            if (arr[idx1] <= arr[idx2]) {
                res[idx3] = arr[idx1];
                idx1++;
                idx3++;
            } else {
                res[idx3] = arr[idx2];
                idx2++;
                idx3++;
            }
        }

        while (idx1 <= mid) {
            res[idx3] = arr[idx1];
            idx1++;
            idx3++;
        }
        while (idx2 <= right) {
            res[idx3] = arr[idx2];
            idx2++;
            idx3++;
        }
        for(int i=left;i<=right;i++){
            arr[i] = res[i-left];
        }
    }

    public int mergeSort(int[] nums, int l, int r){
        int invCount = 0;
        if(l==r){
            return 0;
        }
        int mid = (l+r)/2;
        invCount += mergeSort(nums,l,mid);
        invCount += mergeSort(nums,mid+1,r);
        invCount += calcInv(nums, l, mid, r);
        merge(nums,l,mid,r);
        return invCount;

    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
}