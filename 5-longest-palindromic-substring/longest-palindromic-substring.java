class Solution {
    public String longestPalindrome(String str) {
        if (str.isEmpty()) return "";

        String longestPalindrome = "";
        for (int i = 0; i < str.length(); i++) {
            String palindrome1 = expandAroundCenter(str, i, i);
            String palindrome2 = expandAroundCenter(str, i, i + 1);

            if (palindrome1.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome1;
            }
            if (palindrome2.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome2;
            }
        }
        return longestPalindrome;
    }

    private String expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() 
            && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }
}