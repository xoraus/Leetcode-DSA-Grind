class Solution {
    // Approach 3: 

    public String reverseWords(String str) {
        int right = str.length() - 1;
        StringBuilder res = new StringBuilder();

        // iterate on all words
        while(right >= 0){

            // right will stop at the ending index of a word.
            while(right >= 0 && str.charAt(right) == ' '){
                right--;
            }

            int left = right;
            // left will stop at the starting index of a word.
            while(left >= 0 && str.charAt(left) != ' '){
                left--;
            }

            if(res.length() > 0 && left < right){
                res.append(" ");
            }

            for(int idx = left + 1; idx <= right; idx++){
                res.append(str.charAt(idx));
            }

            right = left;
        }

        return res.toString();
    }
}

 