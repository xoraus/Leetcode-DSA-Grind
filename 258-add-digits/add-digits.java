class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            num = sumOfDigits(num);
        }
        return num;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}