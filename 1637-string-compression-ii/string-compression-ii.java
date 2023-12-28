class Solution {
    private int n;
    private int[][] t;

    public int solve(int i, int k, String s) {
        if (k < 0) {
            return 100000;
        }

        if (i >= n || (n - i) <= k) {
            return 0;
        }

        if (t[i][k] != -1) {
            return t[i][k];
        }

        int delete_i = solve(i + 1, k - 1, s);

        int keep_i = Integer.MAX_VALUE;

        int deleted = 0;
        int freq = 0;
        int addition = 0;

        for (int j = i; j < n && deleted <= k; j++) {
            if (s.charAt(j) == s.charAt(i)) {
                freq++;
                if (freq == 2 || freq == 10 || freq == 100) {
                    addition++;
                }
            } else {
                deleted++;
            }

            keep_i = Math.min(keep_i, 1 + addition + solve(j + 1, k - deleted, s));
        }

        return t[i][k] = Math.min(delete_i, keep_i);
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        n = s.length();
        t = new int[n + 1][k + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve(0, k, s);
    }
}