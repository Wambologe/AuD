package Hash_Tabellen;

import Listenstrukturen.GenericList;

// Seite 634
public class MyHashSet<E> implements GenericSet<E> {
    private static class BucketNode<T> {
        private T key;
        private BucketNode<T> next = null;

        private BucketNode(T key, BucketNode<T> next) {
            this.key = key;
            this.next = next;
        }
    }

    private final static int init_buckets = 256;
    private final static double load_factor = 0.5;
    private BucketNode<E>[] buckets = new BucketNode[MyHashSet.init_buckets];
    private int size = 0;

    private int hash(E key, int M) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    

    // Seite 635
    private BucketNode<E>[] reorganize(BucketNode<E>[] old_buckets, int new_length) {
        BucketNode<E>[] new_buckets = new BucketNode[new_length];
        for (int a = 0; a < old_buckets.length; a++) {
            BucketNode<E> src = old_buckets[a];
            while (src != null) {
                E key = src.key;
                addToTable(new_buckets, key);
                src = src.next;
            }
        }
        return new_buckets;
    }

    private BucketNode<E> seek(BucketNode<E>[] buckets, E key) {
        int hash = hash(key, buckets.length);
        BucketNode<E> cn = buckets[hash];
        while (cn != null && !cn.key.equals(key)) {
            cn = cn.next;
        }
        return cn;
    }

    // Seite 636
    // @Override
    // public boolean contains(E key) {
    //     BucketNode<E> cn = seek(this.buckets, key);
    //     return cn != null;
    // }

    // Seite 637 (Hilfsfunktion)
    private int addToTable(BucketNode<E>[] buckets, E key) {
        int hash = hash(key, buckets.length);
        BucketNode<E> cn = buckets[hash];
        
        /*Existiert noch kein Knoten im
        Bucket, wird ein neuer Knoten
        erzeugt */
        if (cn == null) {
            buckets[hash] = new BucketNode<E>(key, null);
            return 1;
        
        /*Existiert ein Knoten, wird
        die Bucketliste abgelaufen*/
        } else if (!cn.key.equals(key)) {
            while (cn.next != null && !cn.next.key.equals(key)) {
                cn = cn.next;
            }
            // Wird das Ende der Liste
            // erreicht, ist der Schlüssel
            // noch nicht enthalten und es
            // wird ein neuer Knoten
            // angehängt
            if (cn.next == null) {
                cn.next = new BucketNode<E>(key, null);
                return 1;
            }
        }
        return 0;
    }

     // Seite 638
    @Override
    public MyHashSet<E> insert(E key) {
        if (this.size >= load_factor * this.buckets.length) {
            this.buckets = reorganize(this.buckets, this.buckets.length << 1);
        }
        this.size += addToTable(this.buckets, key);
        return this;
    }

    // Seite 639 & 640
    private int removeFromTable(BucketNode<E>[] buckets, E key) {
        int hash = hash(key, buckets.length);
        BucketNode<E> cn = buckets[hash];
        // Existiert kein Knoten im
        // Bucket, ist der Schlüssel
        // nicht enthalten und der
        // Algorithmus beendet
        if (cn == null) {
            return 0;
        // Existiert ein erster Knoten,
        // wird dieser geprüft und
        // gegebenenfalls der
        // Startknoten des Buckets
        // weitergesetzt
        } else {
            if (cn.key.equals(key)) {
                buckets[hash] = cn.next;
                return 1;
            }
            // Befindet sich der
            // Schlüssel nicht im ersten
            // Knoten, wird die übrige
            // Bucketliste abgelaufen
            while (cn.next != null && !cn.next.key.equals(key)) {
                cn = cn.next;
            }
            // Wurde der Schlüssel
            // gefunden, wird der
            // entsprechende Knoten
            // aus der Verkettung
            // entfernt
            if (cn.next != null) {
                cn.next = cn.next.next;
                return 1;
            // Ansonsten ist der
            // Schlüssel nicht enthalten
            // und der Algorithmus
            // beendet
            } else {
                return 0;
            }
        }
    }

    // Seite 641
    // @Override
    // public MyHashSet<E> remove(E key) {
    //     this.size -= removeFromTable(this.buckets, key);
    //     if (this.size < load_factor * (this.buckets.length >> 1)) {
    //         this.buckets = reorganize(this.buckets, this.buckets.length >> 1);
    //     }
    //     return this;
    // }

    @Override
    public GenericList<E> insert(E value, int idx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E remove(int idx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E get(int idx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer indexOf(E value, int start_idx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int length() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }
        
}