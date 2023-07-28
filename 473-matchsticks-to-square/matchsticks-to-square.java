import java.util.Arrays;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks)
            sum += matchstick;

        if (sum % 4 != 0) // The four sides cannot be equal
            return false;

        int sideLen = sum / 4;
        int[] sides = new int[] { sideLen, sideLen, sideLen, sideLen };

        Arrays.sort(matchsticks); // Always try longer matchstick first
        return helper(matchsticks, sides, matchsticks.length - 1); // idx starts from right to left
    }

    private boolean helper(int[] matchsticks, int[] sides, int idx) {
        if (idx == -1) { // use up matchstick, check if all matchsticks are used
            return true; // If all matchsticks are used, we successfully formed a square.
        }

        for (int i = 0; i < sides.length; i++) { // for each matchstick, try four sides
            if (matchsticks[idx] <= sides[i]) { // Check if the current matchstick can be used for this side
                sides[i] -= matchsticks[idx]; // Use the matchstick for this side
                if (helper(matchsticks, sides, idx - 1)) // Recursively check if we can use the remaining matchsticks to form other sides
                    return true; // If we successfully formed a square with the remaining matchsticks, return true.
                sides[i] += matchsticks[idx]; // If the above recursive call returns false, backtrack by removing the matchstick from this side.
            }
        }

        return false; // If we can't form a square using the current matchstick, return false.
    }
}
