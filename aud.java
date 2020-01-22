import Baumstrukturen.MyBSTSet;

public class aud {
    public static void main(final String args[]) {
        System.out.println("Hello");

        // MyBSTSet tree = new MyBSTSet<Integer>();

        // tree.insert(12);
        // tree.insert(40);
        // tree.insert(8);
        // tree.insert(99);
        // tree.insert(77);
        // tree.insert(9);

        // tree.remove(8);

        MyBSTSet treeIterative = new MyBSTSet<Integer>();
        treeIterative.insertIterative(12);
        treeIterative.insertIterative(40);
        treeIterative.insertIterative(8);
        treeIterative.insertIterative(99);
        treeIterative.insertIterative(77);
        treeIterative.insertIterative(9);
        treeIterative.insertIterative(39);
        treeIterative.insertIterative(77);

        treeIterative.removeIterative(99);

    }
}