class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complement = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(complement.containsKey(target-nums[i])==true){
                return new int[]{complement.get(target-nums[i]),i};
            } else {
                complement.put(nums[i],i);
            }
        }
        return null;
    }
}