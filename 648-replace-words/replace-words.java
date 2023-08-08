class Solution {
    public static class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean isTerminal = false;

        public TrieNode getChild(char ch) {
            return children[ch - 'a'];
        }

        public boolean isTerminal() {
            return isTerminal;
        }

        public void setTerminal() {
            isTerminal = true;
        }

        public void addChild(char ch) {
            children[ch - 'a'] = new TrieNode();
        }

        public boolean containsChild(char ch) {
            return (children[ch - 'a'] != null);
        }
    }

    public void insertWord(TrieNode curr, String word) {
        for (char ch : word.toCharArray()) {
            if (!curr.containsChild(ch))
                curr.addChild(ch);

            curr = curr.getChild(ch);
        }
        curr.setTerminal();
    }

    public String searchRoot(TrieNode curr, String word) {
        StringBuilder rootCandidate = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (curr.isTerminal()) {
                return rootCandidate.toString();
            }

            if (!curr.containsChild(ch)) {
                return word;
            }

            rootCandidate.append(ch);
            curr = curr.getChild(ch);
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String word : dictionary)
            insertWord(root, word);

        StringBuilder result = new StringBuilder("");
        for (String word : sentence.split(" ")) {
            if (result.length() > 0)
                result.append(" ");
            result.append(searchRoot(root, word));
        }

        return result.toString();
    }
}
