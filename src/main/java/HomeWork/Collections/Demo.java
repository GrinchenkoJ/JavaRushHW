package HomeWork.Collections;

import java.util.ArrayList;

public class Demo {
    static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);

        System.out.println("Initial array - " + myList);
        System.out.println("List size - " + myList.size());

        myList.addByIndex(4, 1);
        System.out.println("array after changes - " + myList);
        System.out.println(myList.getByIndex(3));
        myList.removeByIndex(0);
        System.out.println("array after changes - " + myList);
        myList.clear();
        System.out.println("array after changes - " + myList);
    }
}