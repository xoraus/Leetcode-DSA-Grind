class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0; // Invalid input for negative k.
        }

        int pairCount = 0;
        Map<Integer, Integer> numberCount = new HashMap<>();

        for (int num : nums) {
            numberCount.put(num, numberCount.getOrDefault(num, 0) + 1);
        }

        for (int num : numberCount.keySet()) {
            if ((k > 0 && numberCount.containsKey(num + k)) || (k == 0 && numberCount.get(num) > 1)) {
                pairCount++;
            }
        }

        return pairCount;
    }
}