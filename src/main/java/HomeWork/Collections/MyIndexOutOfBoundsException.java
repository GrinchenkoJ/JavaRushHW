package HomeWork.Collections;

public class MyIndexOutOfBoundsException extends RuntimeException {

    public MyIndexOutOfBoundsException(String message) {
        super(message);
    }

    public MyIndexOutOfBoundsException(int index, int size) {
        super("Index error! Attempting to access: " + index + ", but the size of the list: " + size);
    }
}
