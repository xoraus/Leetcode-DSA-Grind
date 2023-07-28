class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerset = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), powerset);
        return powerset;
    }

    public void subsets(int[] nums, int idx, List<Integer> subset, List<List<Integer>> powerset) {
        powerset.add(new ArrayList<>(subset));

        for (int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);
            subsets(nums, i + 1, subset, powerset);
            subset.remove(subset.size() - 1);
        }
    }    
}