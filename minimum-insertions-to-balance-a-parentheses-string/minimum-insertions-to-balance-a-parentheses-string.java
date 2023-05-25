class Solution {
    public int minInsertions(String s) {
        int open = 0, additions = 0;

        for(int idx = 0; idx < s.length(); idx++){
            char ch = s.charAt(idx);

            if(ch == '('){
                open++;
            } else if(ch == ')'){

                if(open > 0) open--;
                else additions++; // add one opening character

                if(idx + 1 < s.length() && s.charAt(idx + 1) == ')')
                    idx++;
                else additions++; // add one closing character
            }
        }

        return additions + 2 * open;
    }
}