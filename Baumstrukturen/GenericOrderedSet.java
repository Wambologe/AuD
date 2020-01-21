package Baumstrukturen;

public interface GenericOrderedSet<E> {
	// Baum wird nach Schluessel k durchsucht
	boolean contains(E key);

	// Baum wird nach Schluessel k durchsucht (Iterativ)
	boolean containsIt(E key);
	
	// Kleinster Schluessel
	E minimum();

	// Kleinster Schluessel (Iterativ)
	E minimumIt();
	
	// Groesster Schluessel
	E maximum();

	// Groesster Schluessel (Iterativ)
	E maximumIt();
	
	// Einfuegen des Schluessels k, falls noch nicht vorhanden
	GenericOrderedSet<E> insert(E key);

	// Einfuegen des Schluessels k, falls noch nicht vorhanden (Iterativ)
	GenericOrderedSet<E> insertIt(E key);
	
	// Loeschen des Schluessels k, falls vorhanden
	GenericOrderedSet<E> remove(E key);

	// Loeschen des Schluessels k, falls vorhanden (Iterativ)
	GenericOrderedSet<E> removeIt(E key);
}
