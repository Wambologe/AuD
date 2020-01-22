import BinaryHeaps.*;

public class aud {
    public static void main(final String args[]) {

    // MyBSTSet tree = new MyBSTSet<Integer>();
    // tree.insertIt(12);
    // tree.insertIt(40);
    // tree.insertIt(8);
    // tree.insertIt(99);
    // tree.insertIt(77);
    // tree.insertIt(9);
    // tree.insertIt(39);
    // tree.insertIt(77);

    // System.out.printf("Das Maximum ist: %d\n", tree.maximumIt());
    // System.out.printf("Das Minimum ist: %d\n", tree.minimumIt());

    // System.out.println(tree.containsIt(99));
    // System.out.println(tree.containsIt(12));
    // System.out.println(tree.containsIt(77));

    Integer[] bla = {1, 2, 3};

    MinHeap h = new MinHeap<>(bla);
    System.out.println(h.size());
    h.removeHead();
    h.insert(1);
    }
}