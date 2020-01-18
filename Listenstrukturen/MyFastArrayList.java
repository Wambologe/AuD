public class MyFastArrayList<E> implements GenericList<E> {

	private final static int block = 100;
	@SuppressWarnings("unchecked")
	private E[] vals = (E[]) new Object[MyFastArrayList.block];
	private int used = 0;
	/* ... */

	@Override
	public MyFastArrayList<E> insert(E value, int idx) {
		if (this.vals.length == used) {
			@SuppressWarnings("unchecked")
			E[] new_vals = (E[]) new Object[this.vals.length + MyFastArrayList.block];
			System.arraycopy(this.vals, 0, new_vals, 0, idx);
			System.arraycopy(this.vals, idx, new_vals, idx + 1, this.vals.length - idx);
			new_vals[idx] = value;
			this.vals = new_vals;
		} else {
			System.arraycopy(this.vals, idx, this.vals, idx + 1, this.vals.length - idx);
			this.vals[idx] = value;
		}
		this.used++;
		return this;
	}

	@Override
	public E remove(int idx) {
		E removed = this.vals[idx];
		if (this.used == this.vals.length - MyFastArrayList.block + 1) {
			@SuppressWarnings("unchecked")
			E[] new_vals = (E[]) new Object[this.vals.length - MyFastArrayList.block];
			System.arraycopy(this.vals, 0, new_vals, 0, idx);
			System.arraycopy(this.vals, idx + 1, new_vals, idx, this.vals.length - idx - 1);
			this.vals = new_vals;
		} else {
			System.arraycopy(this.vals, idx + 1, this.vals, idx, this.used - idx - 1);
		}
		this.used--;
		return removed;
	}

	@Override
	public E get(int idx) {
		return this.vals[idx];
	}

	@Override
	public Integer indexOf(E value, int start_idx) {
		int idx = start_idx;
		int l = this.used;
		while ((idx < l) && !(this.vals[idx].equals(value))) {
			idx++;
		}
		return (idx == this.used) ? null : idx;
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
