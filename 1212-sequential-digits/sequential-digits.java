public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> digitQueue = new LinkedList<>();
        for (int startDigit = 1; startDigit <= 8; startDigit++) {
            digitQueue.offer(startDigit);
        }

        List<Integer> result = new ArrayList<>();

        while (!digitQueue.isEmpty()) {
            int currentNumber = digitQueue.poll();

            if (currentNumber >= low && currentNumber <= high) {
                result.add(currentNumber);
            }

            int lastDigit = currentNumber % 10;
            if (lastDigit + 1 <= 9) {
                digitQueue.offer(currentNumber * 10 + (lastDigit + 1));
            }
        }

        return result;
    }
}

