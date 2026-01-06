package HomeWork.Collections;

public class MyKeyNotFoundException extends RuntimeException {
    public MyKeyNotFoundException(Object key) {
        super("Key '" + key + "' not found on the map!");
    }
}
