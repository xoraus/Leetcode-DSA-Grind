class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        // Pass 1: Mark Visited
        for(int idx = 0; idx < n; idx ++){
            int val = (nums[idx] % (n + 1));
            nums[val - 1] += (n + 1); 
        }

        // Pass 2: Missing Numbers
        List<Integer> duplicates = new ArrayList<>();
        for(int idx = 0; idx < nums.length; idx++){
            int freq = nums[idx] / (n + 1);
            if(freq > 1) duplicates.add(idx + 1);
        }
        
        return duplicates;
    }
}