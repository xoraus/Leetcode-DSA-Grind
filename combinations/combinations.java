class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void combine(int n, int k, List<Integer> output){
        if(k == 0){
            result.add(new ArrayList<>(output)); // deep copy
            return;
        }

        if(n == 0) return;

        for(int item = n; item >= 1; item--){
            output.add(item);
            combine(item - 1, k - 1, output);
            output.remove(output.size() - 1); // backtracking;
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        combine(n, k, new ArrayList<>());
        return result;
    }
}