class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> visited = new HashMap<>();

        for(int j=0; j<nums.length; j++){
            Integer i = visited.get(nums[j]);
            if(i == null || j-i > k){
                visited.put(nums[j],j);
            } else return true;
        }
        return false;
    }
}