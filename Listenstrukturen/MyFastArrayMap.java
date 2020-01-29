package Listenstrukturen;

import Listenstrukturen.Pair;

public class MyFastArrayMap<K, V> implements GenericMap<K, V> {
    private final static int block = 100;
    private Pair<K,V>[] vals = (Pair<K,V>[]) new Pair[MyFastArrayMap.block];
    private int used = 0;
    
    @Override
    public MyFastArrayMap<K,V> set(K key, V value) {
        if (!this.contains(key)) {
            int idx = this.used;
            //...
        }
        return this;
    }   

    private int index(K key) {
        int idx = 0;
        while (idx < this.used && !key.equals(this.vals[idx].l())) {
            idx++;
        }
        return idx < this.used ? idx : -1;
    }

    @Override
    public boolean contains(K key) {
        return this.index(key) > -1;
    }

    @Override 
    public V get(K key) {
        int idx = index(key);
        return idx > -1 ? vals[idx].r() : null;
    }

    @Override
    public V remove(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }
}