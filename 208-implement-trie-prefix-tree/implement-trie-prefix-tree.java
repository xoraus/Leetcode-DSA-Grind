class Trie {
    public static class Node {
        private Node[] children = new Node[26];
        private boolean isEnd = false;

        public boolean contains(char ch) {
            return children[ch - 'a'] != null;
        }

        public Node get(char ch) {
            return children[ch - 'a'];
        }

        public void set(char ch) {
            children[ch - 'a'] = new Node();
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.contains(ch)) {
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        curr.setEnd(true);
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.contains(ch)) {
                return false;
            }
            curr = curr.get(ch);
        }
        return curr.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!curr.contains(ch)) {
                return false;
            }
            curr = curr.get(ch);
        }
        return true;
    }
}
