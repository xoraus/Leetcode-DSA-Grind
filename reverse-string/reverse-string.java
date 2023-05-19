class Solution {
    public void reverse(char[] s, int left, int right){
        if(left >= right) return;
        reverse(s, left + 1, right - 1);
        // swap left & right
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);    
    }
}