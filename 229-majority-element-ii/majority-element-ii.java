class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majorityElements = new ArrayList<>();
        int n = nums.length;
        int threshold = n / 3;
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count occurrences of each element in the array
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Check if the frequency of each element is greater than the threshold
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > threshold) {
                majorityElements.add(entry.getKey());
            }
        }
        
        return majorityElements;
    }
}