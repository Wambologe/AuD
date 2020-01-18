public class MyRecursiveListNode<E> implements GenericRecursiveList<E> {
	
	private E value;
	private GenericRecursiveList<E> next = null;
	
	public MyRecursiveListNode(E value, GenericRecursiveList<E> next) {
		this.value = value;
		this.next = next;
	}

	@Override
	public GenericRecursiveList<E> insert(E value, int idx) {
		if (idx == 0) {
			return new MyRecursiveListNode<E>(value, next);
		} else {
			this.next = this.next.insert(value, idx - 1);
			return this;
		}
	}

	@Override
	public GenericRecursiveList<E> remove(int idx) {
		if (idx == 0) {
			return this.next;
		} else {
			this.next = this.next.remove(idx-1);
			return this;
		}
	}

	@Override
	public E get(int idx) {
		if (idx == 0) {
			return this.value;
		} else {
			return this.next.get(idx-1);
		}
	}

	@Override
	public Integer indexOf(E value, int start_idx) {
		if (start_idx <= 0 && this.value.equals(value)) {
			return 0;
		} else {
			return 1 + this.next.indexOf(value, start_idx-1);
		}
	}

	@Override
	public int length() {
		return 1 + this.next.length();
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
	
	

}
