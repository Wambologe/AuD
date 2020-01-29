package Listenstrukturen;

public class Pair<K, V> {
    private K left;
    private V right;
    
    public Pair(K left, V right) {
        this.left = left;
        this.right = right;
    }

    public K l() {
        return this.left;
    }

    public V r() {
        return this.right;
    }

    public String toString() {
        return this.l() + ":" + this.r();
    }
}