import java.util.*;

class Node {
    int data1, data2;
    Node next, prev;

    Node(int data1, int data2) {
        this.data1 = data1;
        this.data2 = data2;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    Node head;
    int size = 0;
    private int capacity = 0;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node current = map.get(key);
        if (current != head) {
            if (current.prev != null) current.prev.next = current.next;
            if (current.next != null) current.next.prev = current.prev;

            current.prev = null;
            current.next = head;
            if (head != null) head.prev = current;
            head = current;
        }
        return current.data2;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existing = map.get(key);
            if (existing.prev != null) existing.prev.next = existing.next;
            else head = existing.next;
            if (existing.next != null) existing.next.prev = existing.prev;

            size--;
            map.remove(key);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        newNode.next = head;
        if (head != null) head.prev = newNode;
        head = newNode;
        size++;

        if (size > capacity) {
            Node current = head;
            while (current.next != null) current = current.next;

            if (current.prev != null) current.prev.next = null;
            else head = null;

            map.remove(current.data1);
            size--;
        }
    }
}