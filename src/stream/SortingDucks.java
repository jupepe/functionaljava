package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import base.CartoonCharacter;

public class SortingDucks {

    private static final CartoonCharacter[] ducks = new CartoonCharacter[] {
            new CartoonCharacter("Donald", "Duck"),
            new CartoonCharacter("Mickey", "Mouse"),
            new CartoonCharacter("Huey", "Duck"),
            new CartoonCharacter("Dewey", "Duck"),
            new CartoonCharacter("Louie", "Duck"),
            new CartoonCharacter("Elvira", "Duck"),
            new CartoonCharacter("Scrooge", "McDuck"),
            new CartoonCharacter("Gladstone", "Gander"),
            new CartoonCharacter("Gus", "Goose") };

    private static void printDucks(String title, CartoonCharacter[] ducks) {
        System.out.println(title);
        Arrays.asList(ducks).stream().forEach(s -> System.out.println(s));
    }

    public static void main(String[] args) {

        // Traditional sorting with Anonymous inner class
        CartoonCharacter[] sortedDucks = Arrays.copyOf(ducks, ducks.length);
        Arrays.sort(sortedDucks, new Comparator<CartoonCharacter>() {
            @Override
            public int compare(CartoonCharacter a, CartoonCharacter b) {
                return a.compareTo(b);
            }
        });
        printDucks("CartoonDucks sorted with anonymous inner class:",
                sortedDucks);

        // Java 8 - sort array using lambda expression
        sortedDucks = Arrays.copyOf(ducks, ducks.length);
        Arrays.sort(sortedDucks,
                (CartoonCharacter a, CartoonCharacter b) -> a.compareTo(b));
        // or simpler: by not specifying the type definition which compiler can detect
        // Arrays.sort(sortedDucks, (a, b) -> a.compareTo(b));
        printDucks("CartoonDucks sorted with lambda expression:",
                sortedDucks);

        // sort array using key-extractor lambdas
        sortedDucks = Arrays.copyOf(ducks, ducks.length);
        Comparator<CartoonCharacter> CartoonDuckComparator = Comparator
                .comparing((CartoonCharacter duck1) -> duck1.getSurname())
                .thenComparing(duck2 -> duck2.getFirstname());
        Arrays.sort(sortedDucks, CartoonDuckComparator);
        printDucks("CartoonDucks sorted with comparator", sortedDucks);

        // sort array passing method references
        sortedDucks = Arrays.copyOf(ducks, ducks.length);
        CartoonDuckComparator = Comparator
                .comparing(CartoonCharacter::getSurname)
                .thenComparing(CartoonCharacter::getFirstname);
        Arrays.sort(sortedDucks, CartoonDuckComparator);
        printDucks("CartoonDucks sorted with existing methods",
                sortedDucks);

        // Create copy of arrayList of ducks
        List<CartoonCharacter> list = new ArrayList<>(Arrays.asList(sortedDucks));

        // reverse sort
        System.out.println(
                "CartoonDucks Sorted in in reverse order");
        list.stream().sorted(CartoonDuckComparator.reversed())
                .forEach(s -> System.out.println(s));

        // Define predicates to remove ducks
        Predicate<CartoonCharacter> predFirstname = duck -> "Gus"
                .equals(duck.getFirstname());
        Predicate<CartoonCharacter> predSurname = duck -> "Duck"
                .equals(duck.getSurname());
        list.removeIf(predFirstname.or(predSurname));

        printDucks("CartoonDucks removed by predicate",
                list.toArray(new CartoonCharacter[list.size()]));

    }
}