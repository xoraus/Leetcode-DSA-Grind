class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        
        for(int ele: nums) {
            ones = (ones^ele) & (~twos);
            twos = (twos^ele) & (~ones);
        }
        
        return ones;
    }
}