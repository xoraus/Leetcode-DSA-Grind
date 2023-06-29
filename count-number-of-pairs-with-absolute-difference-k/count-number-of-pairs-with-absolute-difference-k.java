class Solution {
    public int countKDifference(int[] nums, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int countPairs = 0;
        
        for(int idx = 0; idx < nums.length; idx++){
            if(hmap.containsKey(nums[idx] - target)){
                countPairs += hmap.get(nums[idx] - target);
            }
            if(hmap.containsKey(nums[idx] + target)){
                countPairs += hmap.get(nums[idx] + target);
            }
            
        hmap.put(nums[idx], hmap.getOrDefault(nums[idx], 0) + 1);
        
        }
        return countPairs;
    }
}