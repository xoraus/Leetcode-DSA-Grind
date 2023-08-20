class Solution {
    public int removeDuplicates(int[] nums) {
        int ptr1 = 0;

        for (int ptr2 = 1; ptr2 < nums.length; ptr2++) {
            if (nums[ptr1] != nums[ptr2]) {
                nums[ptr1 + 1] = nums[ptr2];
                ptr1++;
            }
        }
        return ptr1 + 1;
    }
}