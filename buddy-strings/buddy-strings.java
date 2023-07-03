class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;

        if(s.equals(goal)){
            int[] freq = new int[26];
            int count = 0;
            for(int idx = 0; idx < s.length(); idx++){
                count = s.charAt(idx) - 'a';
                freq[count]++;
                if(freq[count] == 2) {
                    return true;
                }
            }
            return false;
        }

        int index1 = -1, index2 = -1;
        for(int idx = 0; idx < s.length(); idx++){
            if(s.charAt(idx) != goal.charAt(idx)){
                if(index1 == -1) index1 = idx;
                else if(index2 == -1) index2 = idx;
                else return false;
            }
        }

        if(index2 == -1) return false;
        return (s.charAt(index1) == goal.charAt(index2) && s.charAt(index2) == goal.charAt(index1));
        
    }
}