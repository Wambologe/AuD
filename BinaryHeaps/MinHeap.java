package BinaryHeaps;

import java.util.Arrays;

public class MinHeap<E extends Comparable<E>> implements GenericPrioQueue<E> {

    private E[] heap = (E[]) new Comparable[1];
    private int heap_size = 0;

    private static int parent(int idx) {
        return (idx-1)/2;
    }

    private static int left_child(int idx) {
        return 2*idx+1;
    }

    private static int right_child(int idx) {
        return 2*idx+2;
    }

    public MinHeap(E[] values) {
        this.heap = values.clone();
        this.heap_size = values.length;
        for (int i = this.heap_size/2; i >= 0; i--) {
            this.heapify(i);
        }
    }

    private void heapify(int i) {
        int smallest = i;
        int l = left_child(i);
        int r = right_child(i);
        if (l < this.heap_size && this.heap[l].compareTo(this.heap[smallest]) < 0) {
            smallest = l;
        } 
        if (r < this.heap_size && this.heap[r].compareTo(this.heap[smallest]) < 0) {
            smallest = r;
        }
        if (smallest != i) {
            E exchange = this.heap[i];
            this.heap[i] = this.heap[smallest];
            this.heap[smallest] = exchange;
            this.heapify(smallest);
        }
    }

    private MinHeap<E> decrease(int i, E new_key) {
        assert i < this.heap_size;
        assert this.heap[i] == null || new_key.compareTo(this.heap[i]) < 0;

        int parent = parent(i);
        this.heap[i] = new_key;
        while (i > 0 && this.heap[parent].compareTo(this.heap[i]) > 0) {
            E exchange = this.heap[i];
            this.heap[i] = this.heap[parent];
            this.heap[parent] = exchange;
            i = parent(i);
            parent = parent(i);
        }
        return this;
    }

    @Override
    public GenericPrioQueue<E> insert(E key) {
        return this.insertHeap(key);
    }

    private MinHeap<E> insertHeap(E key) {
        if (this.heap_size == this.heap.length) {
            this.heap = Arrays.copyOf(this.heap, this.heap.length << 1);
        }
        this.heap_size += 1;
        this.heap[this.heap_size-1] = null;
        this.decrease(this.heap_size-1, key);
        return this;
    }

    @Override
    public E head() {
        assert (this.heap_size > 0);
        return this.heap[0];
    }

    @Override
    public E removeHead() {
        assert this.heap_size > 0;

        E min = this.heap[0];
        this.heap[0] = this.heap[this.heap_size-1];
        this.heap_size -= 1;
        this.heapify(0);
        // Array verkleinern
        return min;
    }    

    @Override
    public int size() {
        return this.heap_size;
    }

    @Override
    public boolean isEmpty() {
        return this.heap_size == 0;
    }
}
