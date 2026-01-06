package HomeWork.Collections;

public class MyLinkedList<T> implements List<T> {

    private static class Node {
        Object item;
        Node next;

        Node(Object item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node first;
    private int size = 0;

    @Override
    public int size() {
        // put your implementation here
        return size;
    }

    @Override
    public void add(T element) {
        // put your implementation here
        Node newNode = new Node(element);

        if(first == null) {
            first = newNode;
        }else {
            Node current = first;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void addByIndex(T element, int index) {
        // put your implementation here
        if(index < 0 || index > size) {
            throw new MyIndexOutOfBoundsException("Index - " + index);
        }

        Node newNode = new Node(element);

        if(index == 0) {
            newNode.next = first;
            first = newNode;
        }else {
            Node prev = findNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public T getByIndex(int index) {
        // put your implementation here
        if(index < 0 || index > size) {
            throw new MyIndexOutOfBoundsException("Index out of bounds");
        }
        Node current = first;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return (T) current.item;
    }

    @Override
    public T removeByIndex(int index) {
        // put your implementation here
        if(index < 0 || index >= size) {
            throw new MyIndexOutOfBoundsException(index, size);
        }
        Object removedItem;
        if(index == 0) {
            removedItem = first.item;
            first = first.next;
        }else {
            Node prev = findNode(index - 1);

            Node target = prev.next;
            removedItem = target.item;

            prev.next = target.next;
            target.next = null;
            target.item = null;
        }
        size--;
        return (T) removedItem;
    }

    @Override
    public void clear() {
        // put your implementation here
        Node current = first;

        while(current != null) {
            Node next = current.next;
            current.item = null;
            current.next = null;

            current = next;
        }
        first = null;
        size = 0;
    }

    private Node findNode(int index) {
        Node current = first;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
