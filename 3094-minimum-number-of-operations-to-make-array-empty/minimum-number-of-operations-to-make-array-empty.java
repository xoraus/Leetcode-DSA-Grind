class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int minOperations = 0;

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if(freq == 1) return -1;

            minOperations += Math.ceil((double) freq / 3);
        }

        return minOperations;
    }
}
