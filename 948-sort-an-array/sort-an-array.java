class Solution {
    public int[] mergeSort(int[] nums, int l, int r){
        if(l==r){
            return new int[]{nums[l]};
        }
        int mid = (l+r)/2;
        int[] left = mergeSort(nums,l,mid);
        int[] right = mergeSort(nums,mid+1,r);
        return merge(left,right);
    }
    public int[] merge(int[] arr1, int[]arr2){
        int[] res = new int[arr1.length+arr2.length];
        int ptr1 = 0, ptr2 = 0, ptr3 = 0;
        while(ptr1<arr1.length && ptr2 < arr2.length){
            if(arr1[ptr1]<=arr2[ptr2]){
                res[ptr3] = arr1[ptr1];
                ptr1++;
                ptr3++;
            } else {
                res[ptr3] = arr2[ptr2];
                ptr2++;
                ptr3++;
            }
        }
        while(ptr1<arr1.length){
            res[ptr3] = arr1[ptr1];
            ptr1++;
            ptr3++;
        }
        while(ptr2<arr2.length){
            res[ptr3] = arr2[ptr2];
            ptr2++;
            ptr3++;
        }
        return res;
    }
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}