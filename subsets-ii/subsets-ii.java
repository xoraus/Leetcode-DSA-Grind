class Solution {
    public List<List<Integer>> uniquePowerset(int[] nums, int idx, List<Integer> subset, List<List<Integer>> powerset) {
        if (idx == nums.length) {
            powerset.add(new ArrayList<>(subset));
            return powerset;
        }

        subset.add(nums[idx]);
        uniquePowerset(nums, idx + 1, subset, powerset);
        subset.remove(subset.size() - 1);

        int subsetSize = subset.size();
        if(subsetSize > 0 && subset.get(subsetSize - 1) == nums[idx]){
            return powerset;
        }
        uniquePowerset(nums, idx + 1, subset, powerset);

        return powerset;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> powerset = new ArrayList<>();
        uniquePowerset(nums, 0, new ArrayList<>(), powerset);
        return powerset;
    }
}