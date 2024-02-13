class Solution {
    public String firstPalindrome(String[] words) {
        for(String word: words){
            if(isPalindrome(word)){
                return word;
            }
        }

        return "";
    }
    
    public boolean isPalindrome(String str){
        str = str.toLowerCase();
        int left = 0, right = str.length() - 1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}