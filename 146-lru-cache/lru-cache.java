public class LRUCache {

    static class CacheNode {
        int key;
        int value;
        CacheNode prev;
        CacheNode next;

        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int currentSize = 0;
    private final int capacity;
    private final CacheNode head;
    private final CacheNode tail;
    private final HashMap<Integer, CacheNode> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new CacheNode(-1, -1);
        this.tail = new CacheNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.currentSize = 0;
        this.cacheMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }

        CacheNode currentNode = cacheMap.get(key);

        // Remove node
        removeNode(currentNode);

        // Add node to the front
        addToFront(currentNode);

        return currentNode.value;
    }

    public void put(int key, int value) {
        if (!cacheMap.containsKey(key)) {
            // Insert new node
            CacheNode newNode = new CacheNode(key, value);

            if (currentSize == capacity) {
                // Remove the last node
                CacheNode lastNode = tail.prev;
                removeNode(lastNode);
                cacheMap.remove(lastNode.key);
            } else {
                currentSize++;
            }

            // Add the new node to the front
            addToFront(newNode);
            cacheMap.put(key, newNode);
        } else {
            // Update existing node
            CacheNode currentNode = cacheMap.get(key);
            removeNode(currentNode);
            addToFront(currentNode);
            currentNode.value = value;
        }
    }

    private void removeNode(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(CacheNode node) {
        node.prev = head;
        node.next = head.next;
        node.prev.next = node;
        node.next.prev = node;
    }
}
 