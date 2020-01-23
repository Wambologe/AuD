package Listenstrukturen;

public class MyArrayList<E> implements GenericList<E> {

	private E[] vals = (E[])new Object[0];

	
	@Override
	public MyArrayList<E> insert(E value, int idx) {
		@SuppressWarnings("unchecked")
		E[] new_vals = (E[])new Object[this.vals.length + 1];
		System.arraycopy(this.vals, 0, new_vals, 0, idx);
		System.arraycopy(this.vals, idx, new_vals, idx + 1, this.vals.length - idx);
		new_vals[idx] = value;
		this.vals = new_vals;
		return this;
	}

	@Override
	public E remove(int idx) {
		E removed = this.vals[idx];
		@SuppressWarnings("unchecked")
		E[] new_vals = (E[])new Object[this.vals.length - 1];
		System.arraycopy(this.vals, 0, new_vals, 0, idx);
		System.arraycopy(this.vals, idx + 1, new_vals, idx, this.vals.length - idx - 1);
		this.vals = new_vals;		
		return removed;
	}

	@Override
	public E get(int idx) {
		return this.vals[idx];
	}

	@Override
	public Integer indexOf(E value, int start_idx) {
		int idx = start_idx;
		int l = this.vals.length;
		while ((idx < l) && !(this.vals[idx].equals(value))) {
			idx++;
		}		
		return (idx == this.vals.length) ? null : idx;
	}

	@Override
	public int length() {
		return this.vals.length;
	}

	@Override
	public boolean isEmpty() {
		return this.vals.length == 0;
	}

}
