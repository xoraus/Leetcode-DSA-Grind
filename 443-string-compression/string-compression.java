class Solution {
    public int compress(char[] chars) {
        String str = new String(chars);
        StringBuilder res = new StringBuilder();
        int left = 0, right = 0;
        
        while (left < str.length()) {
            char ch = str.charAt(left);
            int freq = 0;
            
            while (right < str.length() && str.charAt(right) == ch) {
                freq++;
                right++;
            }
            
            res.append(ch);
            if (freq > 1) {
                res.append(freq);
            }
            left = right;
        }
        
        String compressed = res.toString();
        for (int i = 0; i < compressed.length(); i++) {
            chars[i] = compressed.charAt(i);
        }

        return compressed.length();
    }
}