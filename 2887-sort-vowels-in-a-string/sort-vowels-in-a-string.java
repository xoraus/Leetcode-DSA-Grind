class Solution {
    boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public String sortVowels(String s) {
        // Helper function to check if a character is a vowel

        // Step 1: Separate vowels and consonants
        StringBuilder vowels = new StringBuilder();
        StringBuilder consonants = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.append(c);
            } else {
                consonants.append(c);
            }
        }

        // Step 2: Sort vowels in non-decreasing order of ASCII values
        char[] vowelArray = vowels.toString().toCharArray();
        Arrays.sort(vowelArray);

        // Step 3: Build the resulting string
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        int consonantIndex = 0;

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                // Place vowels in sorted order
                result.append(vowelArray[vowelIndex++]);
            } else {
                // Keep consonants in their original positions
                result.append(consonants.charAt(consonantIndex++));
            }
        }

        return result.toString();
    }
}