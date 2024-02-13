class Solution {
    public String firstPalindrome(String[] words) {
        for (int index = 0; index < words.length; index++) {
            StringBuilder wordReversed = new StringBuilder(words[index]);
            wordReversed.reverse();
            if (words[index].equals(wordReversed.toString())) {
                return words[index];
            }
        }
        return "";
    }
}
