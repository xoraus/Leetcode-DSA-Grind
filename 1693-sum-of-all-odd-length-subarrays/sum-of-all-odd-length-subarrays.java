class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int subarrayCount = (n - i) * (i + 1);
            int oddSubarrays = (subarrayCount + 1) / 2;
            sum += oddSubarrays * arr[i];
        }

        return sum;
    }
}