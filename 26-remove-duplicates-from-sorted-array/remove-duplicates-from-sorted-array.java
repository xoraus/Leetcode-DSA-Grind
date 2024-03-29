class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int num: nums){
            set.add(num);
        }        

        int idx = 0;
        for(int element: set){
            nums[idx++] = element; 
        }

        return set.size();
    }
}