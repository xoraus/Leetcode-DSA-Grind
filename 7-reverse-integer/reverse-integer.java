class Solution {
    public int reverse(int x) {
        // Stores the reversed number
        long reversedNumber = 0;

        // Reversing the digits of the input number
        while (x != 0) {
            int lastDigit = x % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            x = x / 10;
        }

        // Check for integer overflow/underflow
        if (reversedNumber > Integer.MAX_VALUE || reversedNumber < Integer.MIN_VALUE) {
            return 0; // Return 0 if overflow or underflow occurs
        }

        // Handling negative input
        if (x < 0) {
            return (int)(-1 * reversedNumber); // Return the negative reversed number
        }

        // Return the reversed number
        return (int)reversedNumber;
    }
}
