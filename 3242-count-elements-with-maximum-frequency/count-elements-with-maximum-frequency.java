class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int num : nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = -1;
        for (int key : hmap.keySet()) {
            if (hmap.get(key) > maxFreq) {
                maxFreq = hmap.get(key);
            }
        }

        int count = 0;
        for (int num : nums) {
            if (hmap.get(num) == maxFreq) {
                count++;
            }
        }

        return count;
    }
}
