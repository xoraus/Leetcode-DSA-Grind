class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq1 = getFreqArray(s);
        int[] freq2 = getFreqArray(t);

        for (int idx = 0; idx < 26; idx++) {
            if (freq1[idx] != freq2[idx]) {
                return (char) (idx + 'a');
            }
        }

        return ' '; // Handle the case where there is no difference.
    }

    public int[] getFreqArray(String s) {
        int[] freq = new int[26];
        for (int idx = 0; idx < s.length(); idx++) {
            freq[s.charAt(idx) - 'a']++;
        }
        return freq;
    }
}
