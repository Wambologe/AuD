package Listenstrukturen;

public interface GenericSet<E> {
    GenericSet<E> insert(E key);

    GenericSet<E> remove(E key);

    boolean contains(E key);

    int size();

    boolean isEmpty();
}