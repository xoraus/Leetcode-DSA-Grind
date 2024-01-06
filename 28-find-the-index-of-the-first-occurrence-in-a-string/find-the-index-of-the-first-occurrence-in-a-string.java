class Solution {
    public int strStr(String haystack, String needle) {
        int ptr1 = 0, ptr2 = 0;

        while (ptr1 < haystack.length() && ptr2 < needle.length()) {
            char ch1 = haystack.charAt(ptr1);
            char ch2 = needle.charAt(ptr2);

            if (ch1 == ch2) {
                ptr1++;
                ptr2++;
            } else {
                ptr1 = ptr1 - ptr2 + 1;
                ptr2 = 0;
            }
        }

        if (ptr2 == needle.length()) {
            return ptr1 - ptr2;
        } else {
            return -1;
        }
    }
}
