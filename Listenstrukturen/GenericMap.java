package Listenstrukturen;

public interface GenericMap<K,V> {
    GenericMap<K,V> set(K key, V values);

    V remove(K key);

    V get(K key);

    boolean contains(K key);

    int size();

    boolean isEmpty();
}