class Solution {
    public String longestPalindrome(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        
        // A single character itself is a palindrome
        String longestPalindrome = str.substring(0, 1); 
        for (int i = 0; i < length - 1; i++) {
            String palindrome1 = expandAroundCenter(str, i, i);
            if (palindrome1.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome1;
            }
            String palindrome2 = expandAroundCenter(str, i, i + 1);
            if (palindrome2.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome2;
            }
        }
        return longestPalindrome;
    }

    public String expandAroundCenter(String str, int center1, int center2) {
        int left = center1, right = center2;
        int length = str.length();
        while (left >= 0 && right <= length - 1 && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }
}