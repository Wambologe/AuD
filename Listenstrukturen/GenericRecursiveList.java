package Listenstrukturen;

public interface GenericRecursiveList<E> {
	
	/* Einf�gen des Wertes value an Index idx */
	GenericRecursiveList<E> insert(E value, int idx);
	
	/* L�schen des Wertes an Index idx */
	GenericRecursiveList<E> remove(int idx);
	
	/* Bestimmen des Wertes an Index idx */
	E get(int idx);
	
	/* Suchen eines Wertes; liefert den Index des ersten Vorkommens ab inkl.
	 * start_idx bzw. die Nullreferenz, wenn der Wert nicht enthalten ist */
	Integer indexOf(E value, int start_idx);
	
	/* Bestimmen der Listenl�nge */
	int length();
	
	/* Test auf leere Liste */
	boolean isEmpty();
	
}
