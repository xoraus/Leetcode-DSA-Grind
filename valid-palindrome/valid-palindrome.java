// Aprroach 2: Iterative
class Solution {
    public boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int left = 0, right = str.length() - 1;

        while (left <= right) {
            if (!Character.isLetterOrDigit(str.charAt(left))) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(str.charAt(right))) {
                right--;
                continue;
            }

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        
        return true;
    }
}