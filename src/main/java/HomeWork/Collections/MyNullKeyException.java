package HomeWork.Collections;

public class MyNullKeyException extends RuntimeException {
    public MyNullKeyException() {
        super("Error: Key cannot be null!");
    }
}
