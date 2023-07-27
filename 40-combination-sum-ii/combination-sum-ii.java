class Solution {
    public List<List<Integer>> combinationSum2(int[] coins, int target) {
        Arrays.sort(coins); // To remove duplicate combinations
        return printWays(coins, 0, target, new ArrayList<>());
    }
    
    public List<List<Integer>> printWays(int[] coins, int idx, int target, List<Integer> output) {
        List<List<Integer>> ways = new ArrayList<>();

        if (target < 0)
            return ways; // Negative base case: pruning

        if (idx == coins.length) {
            if (target == 0)
                ways.add(new ArrayList<>(output));
            return ways;
        }

        // Yes choice
        output.add(coins[idx]);
        ways.addAll(printWays(coins, idx + 1, target - coins[idx], output));
        output.remove(output.size() - 1);

        // No choice
        if (output.size() > 0 && output.get(output.size() - 1) == coins[idx])
            return ways; // Duplicate combinations discarded

        ways.addAll(printWays(coins, idx + 1, target, new ArrayList<>(output)));

        return ways;
    }
}
