class Solution {
    public int minAddToMakeValid(String s) {
        int unbalanced_open = 0, unbalanced_close = 0;

        for(char ch: s.toCharArray()){
            if(ch == '(') unbalanced_open++;
            else{
                if(unbalanced_open > 0) unbalanced_open--;
                else unbalanced_close++;
            }
        }

        return unbalanced_open + unbalanced_close;
    }
}