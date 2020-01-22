package Baumstrukturen;

public interface GenericOrderedSet<E> {
	// Baum wird nach Schluessel k durchsucht
	boolean contains(E key);
	
	// Kleinster Schluessel
	E minimum();
	
	// Groesster Schluessel
	E maximum();
	
	// Einfuegen des Schluessels k, falls noch nicht vorhanden
	GenericOrderedSet<E> insert(E key);
	
	// Loeschen des Schluessels k, falls vorhanden
	GenericOrderedSet<E> remove(E key);
}
