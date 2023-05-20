class Solution {
    public int[] getConcatenation(int[] nums) {
        int idx1 = 0;
        int idx2 = 0;

        int[] ans = new int[2*nums.length];

        for(int i=0;i<ans.length;i++){
            if(i < nums.length){
                ans[i] = nums[idx1];
                idx1++;
            }
            if(i >= nums.length){
                ans[i] = nums[idx2];
                idx2++;
            }
        }
        return ans;
    }
}