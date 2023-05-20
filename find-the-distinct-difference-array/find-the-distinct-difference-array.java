class Solution {
    public int[] distinctDifferenceArray(int[] nums) {

        int[] res = new int[nums.length];
        
        for(int idx = 0; idx < nums.length; idx++){
            
            HashSet<Integer> set = new HashSet<>();
            int leftDistinct = 0;
            for(int left = 0; left <= idx; left++){
                set.add(nums[left]);
            }
            leftDistinct = set.size();
            
            HashSet<Integer> set2 = new HashSet<>();
            int rightDistinct = 0;
            for(int right = nums.length - 1; right > idx; right--){
                set2.add(nums[right]);
            }
            rightDistinct = set2.size();
            int diff = leftDistinct - rightDistinct;
            res[idx] = diff;
        }
        return res;
    }
}