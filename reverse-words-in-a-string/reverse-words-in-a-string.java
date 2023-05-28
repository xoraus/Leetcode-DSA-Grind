class Solution {
    // Approach 2: 

    public String reverseWords(String str) {
        StringBuilder res = new StringBuilder();

        for(int idx = str.length() - 1; idx >= 0; idx--){
            if(str.charAt(idx) != ' '){
                StringBuilder word = new StringBuilder();
                while(idx >= 0 && str.charAt(idx) != ' '){
                    word.insert(0, str.charAt(idx));
                    idx--;
                }
                if(res.length() == 0){
                    res.append(word);
                } else {
                    res.append(" ");
                    res.append(word);
                }
            }
        }
        
        return res.toString();
    }
}

 