class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();
        
        int minSteps = 0;
        int[] freqMap1 = new int[26];
        int[] freqMap2 = new int[26];

        for (int idx = 0; idx < n; idx++) {
            freqMap1[s.charAt(idx) - 'a']++;
            freqMap2[t.charAt(idx) - 'a']++;
        }

        for (int idx = 0; idx < 26; idx++) {
            minSteps += Math.abs(freqMap1[idx] - freqMap2[idx]);
        }

        return minSteps / 2; 
    }
}
