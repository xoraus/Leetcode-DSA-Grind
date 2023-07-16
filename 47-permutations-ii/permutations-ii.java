public class Solution {
    private List<List<Integer>> uniquePermutations = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for (int value : nums) {
            output.add(value);
        }
        generateUniquePermutations(0, output);
        return uniquePermutations;
    }

    private void generateUniquePermutations(int index, List<Integer> currentPermutation) {
        if (index == currentPermutation.size()) {
            uniquePermutations.add(new ArrayList<>(currentPermutation));
            return;
        }

        Set<Integer> used = new HashSet<>();

        for (int i = index; i < currentPermutation.size(); i++) {
            if (!used.contains(currentPermutation.get(i))) {
                used.add(currentPermutation.get(i));

                Collections.swap(currentPermutation, index, i);
                generateUniquePermutations(index + 1, currentPermutation);
                Collections.swap(currentPermutation, index, i);
            }
        }
    }
}
