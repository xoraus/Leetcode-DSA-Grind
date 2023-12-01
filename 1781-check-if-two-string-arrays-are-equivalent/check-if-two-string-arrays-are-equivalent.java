class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int lengthWord1 = word1.length;
        int lengthWord2 = word2.length;

        int indexWord1 = 0, charIndexWord1 = 0;
        int indexWord2 = 0, charIndexWord2 = 0;

        while (indexWord1 < lengthWord1 && indexWord2 < lengthWord2) {
            char currentCharWord1 = word1[indexWord1].charAt(charIndexWord1);
            char currentCharWord2 = word2[indexWord2].charAt(charIndexWord2);

            if (currentCharWord1 != currentCharWord2)
                return false;

            charIndexWord1++;
            charIndexWord2++;

            if (charIndexWord1 == word1[indexWord1].length()) {
                charIndexWord1 = 0;
                indexWord1++;
            }

            if (charIndexWord2 == word2[indexWord2].length()) {
                charIndexWord2 = 0;
                indexWord2++;
            }
        }

        return indexWord1 == lengthWord1 && indexWord2 == lengthWord2;
    }

}