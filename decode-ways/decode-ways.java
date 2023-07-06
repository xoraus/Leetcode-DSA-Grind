class Solution {
    public int numDecodings(String encodedMessage) {
        int n = encodedMessage.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countDecodings(encodedMessage, 0, dp);
    }

    public int countDecodings(String encodedMessage, int currIdx, int[] dp) {
        if (currIdx == encodedMessage.length())
            return 1;
        if (dp[currIdx] != -1)
            return dp[currIdx];

        int count1 = 0, count2 = 0;
        char currentDigit = encodedMessage.charAt(currIdx);

        if (currentDigit != '0') {
            count1 = countDecodings(encodedMessage, currIdx + 1, dp);
        }

        if (currIdx + 1 < encodedMessage.length()) {
            char nextDigit = encodedMessage.charAt(currIdx + 1);
            int code = (currentDigit - '0') * 10 + (nextDigit - '0');
            if (code >= 10 && code <= 26) {
                count2 = countDecodings(encodedMessage, currIdx + 2, dp);
            }
        }

        return dp[currIdx] = count1 + count2;
    }
}
