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

        int something = (int) tree.minimum();




        
    }
}