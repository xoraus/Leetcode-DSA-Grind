class MapSum {
    public static class MapNode {
        private MapNode[] children = new MapNode[26];
        private int value = 0;
        public int prefixSum = 0;

        public MapNode getChild(char ch) {
            return children[ch - 'a'];
        }

        public int getValue() {
            return value;
        }

        public void addChild(char ch) {
            children[ch - 'a'] = new MapNode();
        }

        public void setValue(int value) {
            this.value = value;
        }

        public boolean containsChild(char ch) {
            return (children[ch - 'a'] != null);
        }
    }

    MapNode root;

    public MapSum() {
        root = new MapNode();
    }

    public int search(String key) {
        MapNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);

            if (!curr.containsChild(ch))
                return 0;

            curr = curr.getChild(ch);
        }
        return curr.getValue();
    }

    public void insert(String key, int val) {
        int oldValue = search(key);

        MapNode curr = root;

        for (int i = 0; i < key.length(); i++) {
            curr.prefixSum += (val - oldValue);

            char ch = key.charAt(i);

            if (!curr.containsChild(ch))
                curr.addChild(ch);

            curr = curr.getChild(ch);
        }

        curr.prefixSum += (val - oldValue);
        curr.setValue(val);
    }

    public int sum(String prefix) {
        MapNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (!curr.containsChild(ch))
                return 0;

            curr = curr.getChild(ch);
        }
        return curr.prefixSum;
    }
}
