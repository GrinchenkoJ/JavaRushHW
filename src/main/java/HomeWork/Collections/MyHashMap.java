package HomeWork.Collections;

public class MyHashMap<K, V> implements Map<K, V> {

    private static class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets;
    private int capacity = 16;
    private int size = 0;

    public MyHashMap() {
        buckets = new Node[capacity];
    }

    private int getBucketIndex(Object key) {
        if(key == null) return 0;
        return Math.abs(key.hashCode()) % capacity;
    }

    @Override
    public int size() {
        // put your implementation here
        return size;
    }

    @Override
    public V put(K key, V value) {
        // put your implementation here
        if (key == null) {
            throw new MyNullKeyException();
        }

        int index = getBucketIndex(key);
        Node head = buckets[index];

        Node current = head;
        while(current != null) {
            if(current.key.equals(key)) {
                Object oldValue = current.value;
                current.value = value;
                return (V) oldValue;
            }
            current = current.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;

        return null;
    }

    @Override
    public V remove(K key) {
        // put your implementation here
        if (key == null) throw new MyNullKeyException();

        int index = getBucketIndex(key);
        Node current = buckets[index];
        Node prev = null;

        while(current != null) {
            if(current.key.equals(key)) {
                Object oldValue = current.value;

                if(prev == null) {
                    buckets[index] = current.next;
                }else {
                    prev.next = current.next;
                }
                size--;
                return (V) oldValue;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        // put your implementation here
        int index = getBucketIndex(key);
        Node current = buckets[index];

        while(current != null) {
            if(current.key.equals(key)) return true;
            current = current.next;
        }
        return false;
    }
}