class Solution {
    public boolean isPalindrome(int x) {
        String orgNum = Integer.toString(x);
        return isPalindrome(orgNum);
    }

    boolean isPalindrome(String orgNum){
        int left = 0, right = orgNum.length() - 1;

        while(left < right){
            char ch_left = orgNum.charAt(left);
            char ch_right = orgNum.charAt(right);
            if(ch_left != ch_right) return false;
            left++; right--;
        }

        return true;
    }
}