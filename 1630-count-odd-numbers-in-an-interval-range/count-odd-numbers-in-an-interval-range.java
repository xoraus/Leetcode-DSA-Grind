class Solution {
    public static int countOdds(int low, int high) {
        // Ensure low is odd, adjust if necessary
        if (low % 2 == 0) {
            low++;
        }

        // Ensure high is odd, adjust if necessary
        if (high % 2 == 0) {
            high--;
        }

        // Calculate the count of odd numbers between low and high
        return (high - low) / 2 + 1;
    }
}