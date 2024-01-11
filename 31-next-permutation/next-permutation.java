class Solution {
    public void nextPermutation(int[] numbers) {
        int arrayLength = numbers.length;
        
        int pivotIndex = findPivot(numbers, arrayLength);
        if(pivotIndex != 0) {
            int swapIndex = findSwapIndex(numbers, arrayLength, pivotIndex);
            swapElements(numbers, pivotIndex - 1, swapIndex);
        }
        reverseSubarray(numbers, pivotIndex, arrayLength - 1);
    }

    private int findPivot(int[] numbers, int arrayLength) {
        int pivotIndex = arrayLength - 1;
        for(; pivotIndex > 0; pivotIndex--) {
            if(numbers[pivotIndex] > numbers[pivotIndex - 1]) {
                break;
            }
        }
        return pivotIndex;
    }

    private int findSwapIndex(int[] numbers, int arrayLength, int pivotIndex) {
        int swapIndex = pivotIndex;
        for(int currentIndex = arrayLength - 1; currentIndex >= pivotIndex; currentIndex--) {
            if(numbers[currentIndex] > numbers[pivotIndex - 1]) {
                swapIndex = currentIndex;
                break;
            }
        }
        return swapIndex;
    }

    private void swapElements(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    private void reverseSubarray(int[] numbers, int start, int end) {
        while(start < end) {
            swapElements(numbers, start, end);
            start++;
            end--;
        }
    }
}