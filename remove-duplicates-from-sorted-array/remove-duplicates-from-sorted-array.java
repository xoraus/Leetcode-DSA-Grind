class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int idx = 0; idx < nums.length; idx++){
            set.add(nums[idx]);
        }
        for(int idx = 0; idx < nums.length - 1; idx++){
            if(nums[idx + 1] == nums [idx]){
                nums[idx] = 101;
            }
        }
        Arrays.sort(nums);
        return set.size();
    }
}