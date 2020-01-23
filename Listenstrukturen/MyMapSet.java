package Listenstrukturen;

public class MyMapSet<E> implements GenericSet<E> {

    private GenericMap<E,Void> l = new MyFastArrayMap<E,Void>();

    @Override
    public MyMapSet<E> insert(E key) {
        this.l.set(key, null);
        return this;
    }

    @Override
    public MyMapSet<E> remove(E key) {
        this.l.remove(key);
        return this;
    }

    @Override
    public boolean contains(E key) {
        return this.l.contains(key);
    }

    @Override
    public int size() {
        return this.l.size();
    }

    @Override
    public boolean isEmpty() {
        return this.l.isEmpty();
    }
}