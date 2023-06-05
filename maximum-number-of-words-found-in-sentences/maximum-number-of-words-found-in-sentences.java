class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        for(int idx = 0; idx < sentences.length; idx++){
            String str = sentences[idx];
            int count = 0;
            for(int spaces = 0; spaces < str.length(); spaces++){
                if(str.charAt(spaces) == ' '){
                    count++;
                }
            }
            maxWords = Math.max(count+1, maxWords);
        }
        return maxWords;
    }
}