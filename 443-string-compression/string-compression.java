class Solution {
    public int compress(char[] chars) {
        int resIndex = 0;
        int left = 0, right = 0;
        
        while (left < chars.length) {
            char ch = chars[left];
            int freq = 0;
            
            while (right < chars.length && chars[right] == ch) {
                freq++;
                right++;
            }
            
            chars[resIndex++] = ch;
            if (freq > 1) {
                String freqStr = Integer.toString(freq);
                for (char digit : freqStr.toCharArray()) {
                    chars[resIndex++] = digit;
                }
            }
            left = right;
        }

        return resIndex;
    }
}