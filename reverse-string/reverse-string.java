class Solution {
    public void swap(char[] ch, int left, int right){
        char tempChar = ch[left];
        ch[left] = ch[right];
        ch[right] = tempChar;
    }

    public void reverse(char[] str, int left, int right){
        if(left >= right) return;
        reverse(str, left + 1, right - 1);
        swap(str, left, right);
    }

    public void reverseString(char[] str) {
        reverse(str, 0, str.length - 1);    
    }
}