class LFUCache {
    
    class Node {
        int key;
        int value;
        int freq;
        Node front;
        Node next;
    }
    
    private void moveNode(Node node) {
        Node pre = node.front;
        while (pre != head && pre.freq <= node.freq) {
            pre = pre.front;
        }
        removeNode(node);
        insertNode(pre, node);
    }
    
    private void insertNode(Node pre, Node node) {
        node.next = pre.next;
        pre.next.front = node;
        node.front = pre;
        pre.next = node;
    }
    
    private void removeNode(Node node) {
        node.front.next = node.next;
        node.next.front = node.front;
    }    
    
    Node head, tail;
    Map<Integer, Node> map;
    int size = 0;
    
    public LFUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.front = head;
        map = new HashMap<>();
        size = capacity;
    }
    
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.freq++;
            moveNode(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.freq++;
            node.value = value;
            moveNode(node);
        } else if (size != 0) {
            if (map.size() == size) {
                map.remove(tail.front.key);
                removeNode(tail.front);
            }
            Node node = new Node();
            node.key = key;
            node.value = value;
            node.freq = 1;
            map.put(key, node);
            insertNode(tail.front, node);
            moveNode(node);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */