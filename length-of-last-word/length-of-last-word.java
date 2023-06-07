class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for(int idx = s.length() - 1; idx >=0; idx--){
            if(s.charAt(idx) != ' '){
                while(idx >= 0 && s.charAt(idx) != ' '){
                    length++;
                    idx--;
                }
                break;
            }
        }
        return length;
    }
}