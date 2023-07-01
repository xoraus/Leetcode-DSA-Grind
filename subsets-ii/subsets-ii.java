class Solution {
    public void findSubsets(int[] nums, int idx, List<Integer> subset, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(subset));
        
        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            findSubsets(nums, i + 1, subset, ansList);
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(nums, 0, new ArrayList<>(), ansList);
        return ansList;
    }
}
