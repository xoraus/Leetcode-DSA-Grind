class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        for(int idx = 0; idx < sentences.length; idx++){
            String str = sentences[idx];
            int count = 0;
            for(int words = 0; words < str.length(); words++){
                if(str.charAt(words) == ' '){
                    count++;
                }
            }
            maxWords = Math.max(count+1, maxWords);
        }
        return maxWords;
    }
}