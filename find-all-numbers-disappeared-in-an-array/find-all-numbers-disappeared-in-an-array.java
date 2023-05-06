class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        // Pass 1: Mark Visited
        for(int i=0; i<n; i++){
            int val = (nums[i] % (n+1));
            nums[val-1] += (n+1); 
        }

        // Pass 2: Missing Numbers
        List<Integer> missing = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] <=n) missing.add(i+1);
        }
        
        return missing;
    }
}