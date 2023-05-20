class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;

        int[] result = new int[2 * n];

        for(int idx = 0; idx < nums.length; idx++){
            result[idx] = nums[idx];
            result[idx + n] = nums[idx];
        }

        return result;
    }
}