class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] targetFreq = new int[26];
        
        for(char ch : p.toCharArray()){
            targetFreq[ch - 'a']--;
        }
        
        for (int right = 0; right < s.length(); right++) {
            targetFreq[s.charAt(right) - 'a']++; // Increment frequency for the right character
            
            int left = right - p.length(); // \U0001f53a
            if (left >= 0) {
                targetFreq[s.charAt(left) - 'a']--; // Decrement frequency for the left character
            }
            
            if (areAnagrams(targetFreq)) {
                result.add(left + 1);
            }
        }
        
        return result;
    }

    public boolean areAnagrams(int[] freq) {
        for(int val: freq){
            if(val != 0) return false;
        }
        return true;
    }
}