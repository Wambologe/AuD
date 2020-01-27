package SS19;

class MaxHeap {
    private int heap[] = new int[1];
    private int heap_size = 0;
    
    static int parent(int i) {
        return (i-2)/2;
    }
    static int left_child(int i) {
        return i*2+1;
    }
    static int right_child(int i) {
        return i*2+2;
    }

    void heapify(int i) {
        int max = i;
        int left = left_child(i);
        int right = left_child(i);

        if (left < this.heap_size && this.heap[left] > this.heap[max]) {
            max = left;
        }
        if (right < this.heap_size && this.heap[right] > this.heap[max]) {
            max = right;
        }
        if (i != max) {
            int temp = this.heap[i];
            this.heap[i] = this.heap[max];
            this.heap[max] = temp;
            this.heapify(max);
        }
    }
}