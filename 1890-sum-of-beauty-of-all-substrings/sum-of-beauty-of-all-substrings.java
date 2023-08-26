class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] bucket = new int[26];
            for (int j = i; j < s.length(); j++) {
                bucket[s.charAt(j) - 'a']++;
                sum += beauty(bucket);
            }
        }
        
        return sum;
    }
    
    private int beauty(int[] bucket) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (bucket[i] == 0) continue;
            min = Math.min(min, bucket[i]);
            max = Math.max(max, bucket[i]);
        }
        return max - min;
    }
}