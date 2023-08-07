class WordDictionary {
    public static class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean isEnd = false;

        public TrieNode getChild(char ch) {
            return children[ch - 'a'];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }

        public void addChild(char ch) {
            children[ch - 'a'] = new TrieNode();
        }

        public boolean hasChild(char ch) {
            return (children[ch - 'a'] != null);
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!curr.hasChild(ch))
                curr.addChild(ch);

            curr = curr.getChild(ch);
        }
        curr.setEnd();
    }

    public boolean search(String word, int idx, TrieNode curr) {
        if (idx == word.length()) {
            return curr.isEnd();
        }

        char ch = word.charAt(idx);

        if (ch != '.') {
            if (!curr.hasChild(ch))
                return false;
            return search(word, idx + 1, curr.getChild(ch));
        }

        for (char chn = 'a'; chn <= 'z'; chn++) {
            if (!curr.hasChild(chn))
                continue;

            if (search(word, idx + 1, curr.getChild(chn)))
                return true;
        }

        return false;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
}
