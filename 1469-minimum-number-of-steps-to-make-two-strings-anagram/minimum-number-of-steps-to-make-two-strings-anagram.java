public class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();
        
        int minSteps = 0;
        int[] map = new int[26];

        for (int i = 0; i < n; i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }        

        for (int i = 0; i < 26; i++) {
            minSteps += Math.max(0, map[i]);
        }

        return minSteps;
    }
}