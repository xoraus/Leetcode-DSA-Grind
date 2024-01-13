class Solution {
    public int minSteps(String s, String t) {
        int minSteps = 0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : s.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            freq2[ch - 'a']++;
        }

        for (int idx = 0; idx < 26; idx++) {
            minSteps += Math.abs(freq1[idx] - freq2[idx]);
        }

        return minSteps / 2; 
    }
}
