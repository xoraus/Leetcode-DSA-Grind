class Solution {
    public void findCombinations(int[] candidates, int currIdx, int remainingTarget, List<List<Integer>> result, List<Integer> combination) {
        if (currIdx == candidates.length) {
            if (remainingTarget == 0) {
                result.add(new ArrayList<>(combination));
                return;
            }
            return;
        }

        if (candidates[currIdx] <= remainingTarget) {
            combination.add(candidates[currIdx]);
            findCombinations(candidates, currIdx, remainingTarget - candidates[currIdx], result, combination);
            combination.remove(combination.size() - 1);
        }
        
        findCombinations(candidates, currIdx + 1, remainingTarget, result, combination);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(candidates, 0, target, result, new ArrayList<>());
        return result;
    }
}
