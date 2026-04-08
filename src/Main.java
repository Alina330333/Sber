import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);

        tree.remove(5);

        Iterator<Integer> iter = tree.iterator();
        while (iter.hasNext()) {
            Integer value = iter.next();
            System.out.println(value);
        }
    }
}