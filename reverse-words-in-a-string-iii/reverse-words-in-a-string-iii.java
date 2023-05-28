class Solution {
    public String reverseWords(String str) {
        StringBuilder res = new StringBuilder();

        for(int idx = 0; idx < str.length(); idx++){
            if(str.charAt(idx) != ' '){
                StringBuilder word = new StringBuilder();
                while(idx < str.length() && str.charAt(idx) != ' '){
                    word.insert(0, str.charAt(idx));
                    idx++;
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