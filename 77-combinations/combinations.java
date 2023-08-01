class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(n, k, new ArrayList<>(), result);
        return result;
    }

    private void combine(int n, int k, List<Integer> output, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(output)); // deep copy
            return;
        }

        if (n == 0) return; // n = 0, but k is still positive

        // Yes choice
        output.add(n);
        combine(n - 1, k - 1, output, result);
        output.remove(output.size() - 1); // backtracking

        // No choice
        combine(n - 1, k, output, result);
    }

}
