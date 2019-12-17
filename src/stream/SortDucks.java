package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import base.CartoonCharacter;

public class SortDucks {

    public static void sortDucks() {
        List<CartoonCharacter> list = new ArrayList<>();
        list.add(new CartoonCharacter("Donald", "Duck"));
        list.add(new CartoonCharacter("Mickey", "Mouse"));
        list.add(new CartoonCharacter("Horace", "Horsecollar"));
        list.add(new CartoonCharacter("Scrooge", "McDuck"));
        list.add(new CartoonCharacter("Gus", "Goose"));

        list.sort((CartoonCharacter p1, CartoonCharacter p2) -> p1
                .getFirstname().compareTo(p2.getFirstname()));
        System.out.println("Collection sorted by first name:");
        System.out.println(list);

        List<CartoonCharacter> reverseList = list.stream().sorted(
                (p1, p2) -> p2.getSurname().compareTo(p1.getSurname()))
                .collect(Collectors.toList());
        System.out.println("Collection reverse sorted by last name:");
        System.out.println(reverseList);

    }

    public static void main(String args[]) {
        sortDucks();
    }
}
