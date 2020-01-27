package WS1819;

class MinHeap {
    private int heap[] = new int[1];
    private int heap_size = 0;

    static int parent(int i) {
        return (i-1)/2;
    }

    static int left_child(int i) {
        return i*2+1;
    }

    static int right_child(int i) {
        return i*2+2;
    }

    Integer minimum() {
        return heap_size == 0 ? null : this.heap[0];
    }

    Integer lookup(int idx, int key) {
        if (idx > heap_size-1 || this.heap[idx] > key) {
            return null;
        } else if (this.heap[idx] == key) {
            return idx;
        } else {
            Integer i = lookup(left_child(idx), key);
            if (i == null) {
                i = lookup(right_child(idx), key);
            }
            return i;
        }
    }
}
