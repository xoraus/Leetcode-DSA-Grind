class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void permute(int[] nums, List<Integer> output){
        if(output.size() == nums.length){
            result.add(new ArrayList<>(output));
            return;
        }

        for(int item: nums){
            if(output.contains(item) == true) continue;
            output.add(item);
            permute(nums, output);
            output.remove(output.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, new ArrayList<>());
        return result;
    }
}
