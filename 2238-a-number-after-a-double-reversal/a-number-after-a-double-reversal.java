class Solution {
    public boolean isSameAfterReversals(int num) {
        int reversed1 = reverseNumber(num);
        int reversed2 = reverseNumber(reversed1);
        return reversed2 == num;
    }
    
    // Function to reverse the digits of a number
    private int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            int lastDigit = num % 10;
            reversed = reversed * 10 + lastDigit;
            num = num / 10;
        }
        return reversed;
    }
}
