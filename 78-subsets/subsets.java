class Solution {

    public void subsets(int[] nums, int idx, List<Integer> subset, List<List<Integer>> powerset){
        if(idx == nums.length){
            powerset.add(new ArrayList(subset));
            return;
        }

        // yes
        subset.add(nums[idx]);
        subsets(nums, idx + 1, subset, powerset);
        subset.remove(subset.size() - 1);

        subsets(nums, idx + 1, subset, powerset);

        return;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerset = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), powerset);
        return powerset;
    }
}
