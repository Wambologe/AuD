import Baumstrukturen.MyBSTSet;

public class aud {
    public static void main(final String args[]) {
        System.out.println("Hello");

        MyBSTSet tree = new MyBSTSet<Integer>();
        tree.insertIt(12);
        tree.insertIt(40);
        tree.insertIt(8);
        tree.insertIt(99);
        tree.insertIt(77);
        tree.insertIt(9);


        System.out.printf("Das Maximum ist: %d\n", tree.maximumIt());
        System.out.printf("Das Minimum ist: %d\n", tree.minimumIt());

        System.out.println(tree.containsIt(99));
        System.out.println(tree.containsIt(98));
        System.out.println(tree.containsIt(77));
    }
}