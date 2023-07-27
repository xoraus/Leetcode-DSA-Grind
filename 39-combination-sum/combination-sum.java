class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ways = new ArrayList<>();
        findWays(candidates, 0, target, new ArrayList<>(), ways);
        return ways;
    }

    public void findWays(int[] candidates, int idx, int target, List<Integer> output, List<List<Integer>> ways) {
        if (target < 0) return; 
        if (idx == candidates.length){
            if (target == 0){
                ways.add(new ArrayList<>(output));
            }
            return;
        }
        
        // yes
        output.add(candidates[idx]);
        findWays(candidates, idx, target - candidates[idx], output, ways);
        output.remove(output.size() - 1);

        // Exclude current coin
        findWays(candidates, idx + 1, target, output, ways);
    } 
}