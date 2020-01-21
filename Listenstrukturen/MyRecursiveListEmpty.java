package Listenstrukturen;

public class MyRecursiveListEmpty<E> implements GenericRecursiveList<E> {

	@Override
	public GenericRecursiveList<E> insert(E value, int idx) {
		return new MyRecursiveListNode<E>(value, this);
	}

	@Override
	public GenericRecursiveList<E> remove(int idx) {
		throw new AssertionError();
	}

	@Override
	public E get(int idx) {
		throw new AssertionError();
	}

	@Override
	public Integer indexOf(E value, int start_idx) {
		return null;
	}

	@Override
	public int length() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

}
