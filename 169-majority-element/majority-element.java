class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int majority = 0;
        int majorityCount = 0;

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);

            if (count > majorityCount) {
                majority = num;
                majorityCount = count;
            }
        }

        return majority;   
    }
}