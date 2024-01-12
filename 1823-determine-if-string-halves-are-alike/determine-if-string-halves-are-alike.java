class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        int LHS = 0, RHS = 0;
        String vowels = "AEIOUaeiou";

        for(int idx = 0; idx < len; idx++){
            char ch = s.charAt(idx);
            if(idx < len / 2){
                if(vowels.contains(ch+"")){
                    LHS++;
                }
            } else {
                if(vowels.contains(ch+"")){
                    RHS++;
                }
            }   
        }

        return LHS == RHS;
    }
}