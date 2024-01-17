class Solution {
    public boolean uniqueOccurrences(int[] numbers) {
        int[] frequencyCount = new int[2001];

        for (int number : numbers) {
            frequencyCount[number + 1000]++;
        }

        Arrays.sort(frequencyCount);
        
        for (int i = 1; i < 2001; i++) {
            if (frequencyCount[i] != 0 && frequencyCount[i] == frequencyCount[i - 1]) {
                return false;
            }
        }

        return true;
    }
    
}