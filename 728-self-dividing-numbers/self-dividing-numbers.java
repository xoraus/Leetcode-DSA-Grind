class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        
        for (int num = left; num <= right; num++) {
            if (isSelfDividing(num)) {
                result.add(num);
            }
        }
        
        return result;
    }
    
    // Function to check if a number is self-dividing
    private boolean isSelfDividing(int num) {
        int originalNum = num;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || originalNum % digit != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
