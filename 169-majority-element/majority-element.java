class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = 0; 
        int lead = 0; 

        for (int num : nums) {
            if (num == majorityElement) {
                lead++;
            } else if (lead == 0) {
                majorityElement = num;
                lead = 1;
            } else {
                lead--;
            }
        }

        return majorityElement;
    }
}