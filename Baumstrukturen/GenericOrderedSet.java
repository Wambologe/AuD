public interface GenericOrderedSet<E> {
	boolean contains(E key);
	
	E minimum();
	
	E maximum();
	
	GenericOrderedSet<E> insert(E key);
	
	GenericOrderedSet<E> remove(E key);
}
