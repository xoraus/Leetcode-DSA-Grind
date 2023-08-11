class Solution {
    public int[] frequencySort(int[] nums) {
        int minValue = -100, maxValue = 100;
        int[] frequencyArray = new int[maxValue - minValue + 1];

        // Pass 1: Create Frequency Array
        for (int num : nums) {
            frequencyArray[num - minValue]++;
        }

        // Pass 2: Create Buckets
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        
        for (int bucket = 0; bucket < buckets.length; bucket++) {
            buckets[bucket] = new ArrayList<>();
        }

        for (int num = minValue; num <= maxValue; num++) {
            int frequency = frequencyArray[num - minValue];
            if (frequency == 0) continue;
            buckets[frequency].add(num);
        }

        // Pass 3: Create Sorted Array
        int idx = 0;
        for (int bucket = 1; bucket < buckets.length; bucket++) {
            Collections.reverse(buckets[bucket]);
            for (int num : buckets[bucket]) {
                for (int freq = 0; freq < bucket; freq++) {
                    nums[idx++] = num;
                }
            }
        }

        return nums;
    }
}