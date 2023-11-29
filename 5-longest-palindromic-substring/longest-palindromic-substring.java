class Solution {
    public String longestPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        String s2 = new String(rev);
        return longestCommonSubstring(s, s2);
    }

    public String longestCommonSubstring(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        String res = "";
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);

                if (ch1 == ch2) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];

                    if (dp[i][j] >= res.length()) {
                        String curr = s1.substring(i, i + dp[i][j]);
                            if (isPalindrome(curr)) {
                            res = curr;
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}