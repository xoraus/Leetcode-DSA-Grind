class Solution {
    public static class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;

        public TrieNode getChild(char ch) {
            return children[ch - 'a'];
        }

        public void setChild(char ch) {
            children[ch - 'a'] = new TrieNode();
        }

        public boolean hasChild(char ch) {
            return (children[ch - 'a'] != null);
        }
    }

    public void insertWord(TrieNode current, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!current.hasChild(ch))
                current.setChild(ch);

            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    String longestPrefix = "";

    public void findLongestCommonPrefix(TrieNode current, String prefix) {
        int childCount = 0;

        if (prefix.length() > longestPrefix.length()) {
            longestPrefix = prefix;
        }

        if (current.isEndOfWord) {
            return;
        }

        char uniqueChild = 'a';
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (current.hasChild(ch)) {
                childCount++;
                uniqueChild = ch;
            }
        }

        if (childCount == 1)
            findLongestCommonPrefix(current.getChild(uniqueChild), prefix + uniqueChild);
    }

    public String longestCommonPrefix(String[] strings) {
        TrieNode root = new TrieNode();
        for (String str : strings) {
            insertWord(root, str);
        }

        findLongestCommonPrefix(root, "");
        return longestPrefix;
    }
}
