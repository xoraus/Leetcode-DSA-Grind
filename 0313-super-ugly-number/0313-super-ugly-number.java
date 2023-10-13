class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ptr = new int[primes.length];
        long[] ugly = new long[n];
        ugly[0] = 1; // Add 1st Ugly No at Index 0

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;

            // Find the next Smallest Ugly No
            for (int j = 0; j < primes.length; j++)
                min = Math.min(min, ugly[ptr[j]] * primes[j]);

            ugly[i] = min;

            // Update all pointers pointing to the minimum
            for (int j = 0; j < primes.length; j++) {
                if (ugly[ptr[j]] * primes[j] == min)
                    ptr[j]++;
            }
        }

        return (int)ugly[n - 1];
    }
}
