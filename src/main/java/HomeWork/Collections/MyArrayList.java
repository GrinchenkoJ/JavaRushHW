package HomeWork.Collections;

import java.lang.reflect.Array;
import java.util.Collections;

public class MyArrayList<T> implements List<T> {

    private int size = 0;
    public Object[] elementList;

    public MyArrayList() {
        elementList = new Object[10];
    }

    @Override
    public int size() {
        // put your implementation here
        return size;
    }

    @Override
    public void add(T element) {
        // put your implementation here
        if(size == elementList.length) {
            grow();
        }
        elementList[size] = element;
        size++;
    }

    @Override
    public void addByIndex(T element, int index) {
        // put your implementation here
        if (index < 0 || index > size) {
            throw new MyIndexOutOfBoundsException(index, size);
        }

        if (size == elementList.length) {
            grow();
        }

        for(int i = size; i > index; i--) {
            elementList[i] = elementList[i - 1];
        }

        elementList[index] = element;

        size++;
    }

    @Override
    public T getByIndex(int index) {
        // put your implementation here
        if(index < 0 || index >= size) {
            throw new MyIndexOutOfBoundsException(index, size);
        }
        return (T) elementList[index];
    }

    @Override
    public T removeByIndex(int index) {
        // put your implementation here
        if (index < 0 || index >= size) {
            throw new MyIndexOutOfBoundsException(index, size);
        }

        Object removeElement = elementList[index];

        int elementMoved = size - index - 1;

        if(elementMoved > 0) {
            for(int i = index; i < size - 1; i++) {
                elementList[i] = elementList[i + 1];
            }
        }

        size--;
        elementList[size] = null;
        return (T) removeElement;
    }

    @Override
    public void clear() {
        // put your implementation here
        for(int i = 0; i < size; i++) {
            elementList[i] = null;
        }
        size = 0;
    }

    private void grow() {
        Object[] newList = new Object[elementList.length *2];
        for(int i = 0; i < elementList.length; i++) {
            newList[i] = elementList[i];
        }
        elementList = newList;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]"; // If empty, return the brackets

        String result = "[";
        for (int i = 0; i < size; i++) {
            result += elementList[i]; // We add an element
            if (i < size - 1) {
                result += ", "; // Add a comma if it is not the last element
            }
        }
        result += "]";
        return result;
    }
}
