public class Solution {
    public int countOdds(int low, int high) {
        int range = high - low + 1;
        int count = range / 2;

        if (range % 2 != 0 && low % 2 != 0)
            count += 1;

        return count;
    }
}
