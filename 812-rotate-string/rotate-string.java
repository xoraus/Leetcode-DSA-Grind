class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        
        // Check if lengths are equal; if not, return false
        if (n != m) {
            return false;
        }
        
        // Concatenate s with itself to form a doubled string
        String doubledString = s + s;
        
        // Build the prefix function for goal
        int[] prefixFunction = new int[m];
        int j = 0; // The length of the previous longest prefix suffix
        
        for (int i = 1; i < m; i++) {
            while (j > 0 && goal.charAt(i) != goal.charAt(j)) {
                j = prefixFunction[j - 1];
            }
            
            if (goal.charAt(i) == goal.charAt(j)) {
                j++;
            }
            
            prefixFunction[i] = j;
        }
        
        // Traverse the concatenated string
        j = 0; // Pointer for goal
        for (int i = 0; i < 2 * n; i++) {
            while (j > 0 && doubledString.charAt(i) != goal.charAt(j)) {
                j = prefixFunction[j - 1];
            }
            
            if (doubledString.charAt(i) == goal.charAt(j)) {
                j++;
            }
            
            if (j == m) {
                return true; // Found a match
            }
        }
        
        return false; // No match found
    }
}
