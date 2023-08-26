class Solution {
    public int myAtoi(String str) {
        int sign = 1;
        int result = 0;
        int currentIndex = 0;
        int strLength = str.length();
        
        // Skip leading spaces
        while (currentIndex < strLength && str.charAt(currentIndex) == ' ')
            currentIndex++;
        
        // Handle sign
        if (currentIndex < strLength && str.charAt(currentIndex) == '+') {
            sign = 1;
            currentIndex++;
        } else if (currentIndex < strLength && str.charAt(currentIndex) == '-') {
            sign = -1;
            currentIndex++;
        }
        
        // Convert digits to integer
        while (currentIndex < strLength && Character.isDigit(str.charAt(currentIndex))) {
            int digit = str.charAt(currentIndex) - '0';
            
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return result = (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
            }
            
            result *= 10;
            result += digit;
            currentIndex++;
        }
        
        return result * sign;
    }
}