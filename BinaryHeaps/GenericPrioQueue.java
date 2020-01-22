package BinaryHeaps;

public interface GenericPrioQueue<E extends Comparable<E>> {

    /* Einreihen von key in die Warteschlange */
    GenericPrioQueue<E> insert(E key);

    /* Liefert das kleinste Element der Warteschlange */
    E head();

    /* Liefert und entfernt das kleinste Element aus der Warteschlange */
    E removeHead();

    /* Anzahl der Elemente der Warteschlange */
    int size();

    /* Test auf leere Warteschlange */
    boolean isEmpty();
}