class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0l, 1); // Empty Subarray

        long sum = 0l;
        int count = 0;

        for(int i=0; i<nums.length; i++){
            sum+= nums[i];
            
            int freq = map.getOrDefault(sum-k, 0);
            count += freq;

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}