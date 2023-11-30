class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memoization = new Boolean[s.length() + 1][p.length() + 1];
        return memo(0, 0, s, p, memoization);
    }

    private boolean memo(int i, int j, String s, String p, Boolean[][] memo) {
        if (i == s.length() && j == p.length()) {
            return true;
        }

        if (i < s.length() && j == p.length()) {
            // First string is not empty, second string is empty
            return false;
        }

        if (i == s.length() && j < p.length()) {
            // First string is empty, second string is still left
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        if (memo[i][j] != null)
            return memo[i][j];

        char charS = s.charAt(i);
        char charP = p.charAt(j);

        if (charS == charP || charP == '?') {
            return memo[i][j] = memo(i + 1, j + 1, s, p, memo);
        }

        if (charP == '*') {
            boolean no = memo(i, j + 1, s, p, memo);
            if (no)
                return memo[i][j] = true;

            boolean yes = memo(i + 1, j, s, p, memo);
            return memo[i][j] = yes;
        }

        // Unequal characters
        return memo[i][j] = false;
    }
}
