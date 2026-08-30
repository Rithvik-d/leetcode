class MyHashMap {
    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 10007;
    private final Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Node curr = buckets[index];

        if (curr == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            if (curr.next == null) {
                curr.next = new Node(key, value);
                return;
            }
            curr = curr.next;
        }
    }

    public int get(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];

        if (curr == null) {
            return;
        }

        if (curr.key == key) {
            buckets[index] = curr.next;
            return;
        }

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    private int getIndex(int key) {
        return key % SIZE;
    }
}