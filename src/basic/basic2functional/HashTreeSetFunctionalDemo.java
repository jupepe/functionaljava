package basic.basic2functional;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HashTreeSetFunctionalDemo {

    public static void main(String args[]) {
        Integer tmp[] = { 30, 20, 10, 60, 40, 50 };
        Set<Integer> set = new HashSet<>();
        set = Set.of(tmp);

        // In HashSet nodes are not sorted
        System.out.println("HashSet:" + set);

        // In the TreeSet nodes are sorted
        TreeSet<Integer> tree = new TreeSet<>(set);
        System.out.println("TreeSet:" + tree);

        // Print the first and the last node
        System.out.println(
                "1st: " + tree.first() + ", and last: " + tree.last());

        // print all nodes using Iterator
        tree.stream().forEach(s -> System.out.println(s + ", "));

        // print the head and tail from the tree (before and after 30)
        System.out.println();

        Set<Integer> beforeValSet = tree.stream().takeWhile(i -> i < 30).collect(Collectors.toSet());
        Set<Integer> afterValSet = tree.stream().dropWhile(i -> i < 30).collect(Collectors.toSet());
        System.out.println("Nodes <30:" +  new TreeSet<>(beforeValSet));
        System.out.println("Nodes >=30:" + new TreeSet<>(afterValSet));
        // Remove the numbers 30 and 40 from the tree
        Set<Integer> filteredTree = tree.stream().filter(i -> i != 30 && i != 40).collect(Collectors.toSet());
        System.out.println(new TreeSet<>(filteredTree));
    }
}
