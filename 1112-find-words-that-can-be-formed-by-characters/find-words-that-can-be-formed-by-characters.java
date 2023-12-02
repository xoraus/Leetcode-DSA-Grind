public class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] availableCharCount = new int[26];

        // Count the occurrences of each character in the given chars string
        for (char ch : chars.toCharArray()) {
            availableCharCount[ch - 'a']++;
        }

        int totalLength = 0;

        // Iterate through each word in the array
        for (String word : words) {
            int[] wordCharCount = new int[26];

            // Count the occurrences of each character in the current word
            for (char ch : word.toCharArray()) {
                wordCharCount[ch - 'a']++;
            }

            // Check if the current word can be formed using characters from chars
            boolean isGoodWord = true;
            for (int i = 0; i < 26; i++) {
                if (wordCharCount[i] > availableCharCount[i]) {
                    isGoodWord = false;
                    break;
                }
            }

            // If the word is good, add its length to the total length
            if (isGoodWord) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }
}
