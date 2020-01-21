import Baumstrukturen.MyBSTSet;

public class aud {
    public static void main(final String args[]) {
        System.out.println("Hello");

        MyBSTSet tree = new MyBSTSet<Integer>();
        tree.insert(12);
        tree.insert(40);
        tree.insert(8);
        tree.insert(99);
        tree.insert(77);
        tree.insert(9);

        int something = (int) tree.minimum();




        
    }
}