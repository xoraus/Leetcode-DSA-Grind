class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates to handle duplicates
        findCombinations(candidates, 0, target, result, combination);
        return result;
    }
    
    public void findCombinations(int[] candidates, int currIdx, int remainingTarget, List<List<Integer>> result, List<Integer> combination) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = currIdx; i < candidates.length; i++) {
            if (i > currIdx && candidates[i] == candidates[i - 1]) {
            // Skip duplicates to avoid duplicate combinations
                continue; 
            }
            if (candidates[i] > remainingTarget) {
            // Optimization: Stop exploring further if candidate is greater than remaining target
                break; 
            }

            combination.add(candidates[i]);
            findCombinations(candidates, i + 1, remainingTarget - candidates[i], result, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
