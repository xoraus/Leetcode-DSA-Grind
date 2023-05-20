class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        HashMap<Integer, Integer> suffix = new HashMap<>();

        int[] result = new int[nums.length];

        for(int val: nums){
            suffix.put(val, suffix.getOrDefault(val, 0) + 1);
        }

        for(int idx = 0; idx < nums.length; idx++){
            Integer val = nums[idx];
            prefix.put(val, prefix.getOrDefault(val, 0) + 1);
            suffix.put(val, suffix.get(val) - 1);
            if(suffix.get(val) == 0){
                suffix.remove(val);
            }
            result[idx] = prefix.size() - suffix.size();
        }

        return result;
    }
}