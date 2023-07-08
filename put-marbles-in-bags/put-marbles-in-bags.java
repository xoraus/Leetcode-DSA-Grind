class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairs = new int[n - 1];

        for(int idx = 1; idx < n; idx++){
            pairs[idx - 1] = weights[idx] + weights[idx - 1]; 
        }

        Arrays.sort(pairs);
        long min = 0, max = 0;

        for(int idx = 0; idx < k - 1; idx ++){
            min += pairs[idx];
            max += pairs[n - idx - 2];
        }

        return max - min;
    }
}