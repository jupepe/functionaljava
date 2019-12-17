package basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HashTreeSetDemo {

    public static void main(String args[]) {
        int tmp[] = { 30, 20, 10, 60, 40, 50 };
        Set<Integer> set = new HashSet<>();

        // In HashSet nodes are not sorted 
        for (int i = 0; i <= 5; i++) {
            set.add(tmp[i]);
        }
        System.out.println("HashSet:" + set);

        // In the TreeSet nodes are sorted
        TreeSet<Integer> tree = new TreeSet<>(set);
        System.out.println("TreeSet:" + tree);

        // Print the first and the last node
        System.out.println(
                "1st: " + tree.first() + ", and last: " + tree.last());

        // print all nodes using Iterator
        Iterator<Integer> iterator = tree.iterator();
        System.out.print("Data in tree: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(", ");
            }
        }

        // print the head and tail from the tree (before and after 30)
        System.out.println();

        System.out.println("Nodes <30:" + tree.headSet(30));
        System.out.println("Nodes >=30:" + tree.tailSet(30));
        // Remove the numbers 30 and 40 from the tree
        tree.remove(30);
        tree.remove(40);
        System.out.println("After removing: " + tree);
    }
}
