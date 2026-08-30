class LRUCache {

        private class Node{
            int key;
            int value;
            Node prev;
            Node next;
            Node(int key, int value){
                this.key = key;
                this.value=value;
            }

        }
    private final int capacity;
    private final Map<Integer,Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity= capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node= cache.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value= value;
            moveToHead(node);
        }else{
            if (cache.size() == capacity) {
                Node lruNode = tail.prev;
                cache.remove(lruNode.key); 
                removeNode(lruNode);      
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
        }
        }
    

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */