class Solution {
    public static class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean isEndOfWord = false;

        public TrieNode getChild(char ch) {
            return children[ch - 'a'];
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord() {
            isEndOfWord = true;
        }

        public void addChild(char ch) {
            children[ch - 'a'] = new TrieNode();
        }

        public boolean containsChild(char ch) {
            return (children[ch - 'a'] != null);
        }
    }

    public void insertWord(String word, TrieNode curr) {
        for (char ch : word.toCharArray()) {
            if (!curr.containsChild(ch))
                curr.addChild(ch);

            curr = curr.getChild(ch);
        }
        curr.setEndOfWord();
    }

    String longestConstructedWord = "";

    public void dfsLongestConstructedWord(TrieNode root, String currentWord) {
        if (!root.isEndOfWord())
            return;

        if (currentWord.length() > longestConstructedWord.length())
            longestConstructedWord = currentWord;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (root.containsChild(ch))
                dfsLongestConstructedWord(root.getChild(ch), currentWord + ch);
        }
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words)
            insertWord(word, root);

        root.setEndOfWord();

        dfsLongestConstructedWord(root, "");
        return longestConstructedWord;
    }
}
