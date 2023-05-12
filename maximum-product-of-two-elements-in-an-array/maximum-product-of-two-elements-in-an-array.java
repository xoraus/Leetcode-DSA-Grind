class Solution {
    public int maxProduct(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int idx = 0; idx < nums.length; idx++){
            if(nums[idx] >= largest){
                secondLargest = largest;
                largest = nums[idx];
            } else if(nums[idx] > secondLargest){
                secondLargest = nums[idx];
            }

            if(nums[idx] <= smallest){
                secondSmallest = nums[idx];
                smallest = nums[idx];
            } else if(nums[idx] < secondLargest){
                secondSmallest = nums[idx];
            }
        }

        int choice1 = (largest -1) * (secondLargest - 1);
        int choice2 = (smallest -1) * (secondSmallest -1);

        return Math.max(choice1, choice2);
    }
}