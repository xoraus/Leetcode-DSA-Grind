class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums); 
        int count = 0;
        int prevNum = Integer.MIN_VALUE; 

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == prevNum) {
                continue; 
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) == k) {
                    count++;
                    break; 
                }
            }
            prevNum = nums[i]; 
        }

        return count;
    }
}