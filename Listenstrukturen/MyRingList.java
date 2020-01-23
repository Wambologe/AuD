package Listenstrukturen;

public class MyRingList<E> implements GenericList<E> {

    private static class ListNode<T> {
        private T value;
        private ListNode<T> prev = null;
        private ListNode<T> next = null;

        private ListNode() {
            this.value = null;
            this.prev = this;
            this.next = this;
        }

        private ListNode(T value, ListNode<T> prev, ListNode<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private int length = 0;
    private ListNode<E> first = new ListNode<>();

    @Override
    public MyRingList<E> insert(E value, int idx) {
        ListNode<E> curr = this.first;
        if (idx < (this.length/2)) {
            while (idx-- > 0) {
                curr = curr.next;
            }
            ListNode<E> newnode = new ListNode<>(value, curr, curr.next);
            curr.next.prev = newnode;
            curr.next = newnode;
        } else {
            while (idx++ < this.length) {
                curr = curr.prev;
            }
            ListNode<E> newnode = new ListNode<>(value, curr.prev, curr);
            curr.prev.next = newnode;
            curr.prev = newnode;
        }
        ++this.length;
        return this;
    }

    @Override
    public E remove(int idx) {
        E removed = null;
        ListNode<E> curr = this.first;
        if (idx < (length/2)) {
            while (idx-- > 0) {
                curr = curr.next;
            }
            removed = curr.next.value;
            curr.next.next.prev = curr;
            curr.next = curr.next.next;
        } else {
            while (idx++ < this.length-1) {
                curr = curr.prev;
            }
            removed = curr.prev.value;
            curr.prev.prev.next = curr;
            curr.prev = curr.prev.prev;
        }
        --this.length;
        return removed;
    }

    @Override
    public E get(int idx) {
        ListNode<E> curr = this.first;
        if (idx < (length/2)) {
            while (idx-- >= 0) {
                curr = curr.next;
            }
        } else {
            while (idx++ < this.length) {
                curr = curr.prev;
            }
        }
        return curr.value;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public Integer indexOf(E value, int start_idx) {
        int curr_idx = 0;
        ListNode<E> curr = this.first;

        if (start_idx < (this.length/2)) {
            while (curr_idx != start_idx) {
                curr = curr.next;
                curr_idx++;
            }
        } else {
            curr_idx = this.length+1;
            while (curr_idx != start_idx) {
                curr = curr.prev;
                curr_idx--;
            }
        }
        while (curr.next != this.first && !curr.next.value.equals(value)) {
            curr = curr.next;
            curr_idx++;
        }
        return (curr.next != this.first) ? curr_idx : null;
    }
}