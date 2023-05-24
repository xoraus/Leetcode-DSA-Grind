class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int ptr1 = 0, ptr2 = n;
        int idx = 0;
        
        while(ptr2 < 2 * n){
            res[idx] = nums[ptr1];
            res[idx+1] = nums[ptr2];
            ptr1++;
            ptr2++;
            idx = idx + 2;

        }
        return res;
    }
}