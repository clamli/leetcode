class DoubleLinkNode {
    int key;
    int value;
    DoubleLinkNode pre;
    DoubleLinkNode post;
}




class LRUCache {


    int count = 0;
    int size = 0;
    private Map<Integer, DoubleLinkNode> cache;
    DoubleLinkNode head, tail;

        
    public LRUCache(int capacity) {
        size = capacity;
        cache = new HashMap<>();
        head = new DoubleLinkNode();
        tail = new DoubleLinkNode();
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DoubleLinkNode node = cache.get(key);
        if (node == null) return -1;
        moveNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DoubleLinkNode node = cache.get(key);
        if (node == null) {
            node = new DoubleLinkNode();
            node.key = key;
            node.value = value;
            addNode(node);
            cache.put(key, node);
            count++;
            if (count > size) {
                cache.remove(removeTail());
            }
        } else {
            moveNode(node);
            node.value = value;
        }
    }
    
    
    public void addNode(DoubleLinkNode node) {
        DoubleLinkNode latter = head.post;
        head.post = node;
        node.pre = head;
        node.post = latter;
        latter.pre = node;
    }

    public void removeNode(DoubleLinkNode node) {
        DoubleLinkNode former = node.pre;
        DoubleLinkNode latter = node.post;
        former.post = latter;
        latter.pre = former;
    }

    public int removeTail() {
        DoubleLinkNode former = tail.pre;
        removeNode(former);
        return former.key;
    }

    public void moveNode(DoubleLinkNode node) {
        removeNode(node);
        addNode(node);
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */