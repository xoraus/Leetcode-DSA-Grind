class Solution {
    public int missingNumber(int[] nums) {
        // Summation of first N numbers:
        int sumOfAllNumbers = (nums.length * (nums.length + 1)) / 2;

        // Summation of all array elements:
        int sumOfArrayElements = 0;
        for(int num: nums){
            sumOfArrayElements += num;
        }

        int missingNumber = sumOfAllNumbers - sumOfArrayElements;
        return missingNumber;
    }
}