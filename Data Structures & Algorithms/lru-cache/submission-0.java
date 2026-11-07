class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);     // Disconnect from current position
        insertToTail(node); // Move to end (Most Recently Used)
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value; // Update value
            remove(node);
            insertToTail(node);
        } else {
            if (map.size() == capacity) {
                // Evict the Least Recently Used (head.next)
                Node lru = head.next;
                map.remove(lru.key);
                remove(lru);
            }
            
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertToTail(newNode);
        }
    }

    // Helper method to remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper method to insert a node right before the dummy tail
    private void insertToTail(Node node) {
        Node currentTail = tail.prev;
        currentTail.next = node;
        node.prev = currentTail;
        node.next = tail;
        tail.prev = node;
    }
}
