package HomeWork.Collections;

public interface Map<K, V> {

    int size();

    V put(K key, V value);

    V remove(K key);

    boolean containsKey(K key);

}
