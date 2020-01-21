package Listenstrukturen;

public class MyLinkedList<E> implements GenericList<E> {

	private static class ListNode<T> {
		private T value;
		private ListNode<T> next = null;

		private ListNode(T value, ListNode<T> next) {
			this.value = value;
			this.next = next;
		}
	}

	private ListNode<E> first = new ListNode<E>(null, null);
	/* ... */

	@Override
	public MyLinkedList<E> insert(E value, int idx) {
		ListNode<E> curr = this.first;
		while (idx-- > 0) {
			curr = curr.next;
		}
		curr.next = new ListNode<E>(value, curr.next);
		return this;
	}

	@Override
	public E remove(int idx) {
		E removed = null;
		ListNode<E> curr = this.first;
		while (idx-- > 0) {
			curr = curr.next;
		}
		removed = curr.next.value;
		curr.next = curr.next.next;
		return removed;
	}

	@Override
	public E get(int idx) {
		ListNode<E> curr = this.first;
		while (idx-- > 0) {
			curr = curr.next;
		}
		return curr.next.value;
	}

	@Override
	public Integer indexOf(E value, int start_idx) {
		int curr_idx = 0;
		ListNode<E> curr = this.first;
		
		while (curr_idx < start_idx) {
			curr = curr.next;
			curr_idx++;
		}
		
		while (curr.next != null && !curr.next.value.equals(value)) {
			curr = curr.next;
			curr_idx++;
		}
		
		return (curr.next != null) ? curr_idx : null;		
	}

	@Override
	public int length() {
		int result = 0;
		ListNode<E> curr = this.first;
		while (curr.next != null) {
			curr = curr.next;
			result++;
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.first.next == null;
	}

}
