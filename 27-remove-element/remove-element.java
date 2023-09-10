class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int num: nums){
            if(num == val){
                count++;
            }
        }

        int idx = 0;
        for(int num: nums){
            if(num == val)
                nums[idx++] = 51;
            else
                nums[idx++] = num;
        }

        Arrays.sort(nums);

        return nums.length - count;
    }
}