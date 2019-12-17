package basic.basic2functional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PrintCollectionFunctionalDemo {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void printRawCollStream(Collection c) {

        c.stream().forEach(e -> System.out
                .println(e + "(" + e.getClass().getName() + "), "));

    }

    public static void printCollStreamGenerics(Collection<?> coll) {

        coll.stream().forEach(e -> System.out
                .println(e + "(" + e.getClass().getName() + ") , "));

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String args[]) {

        Collection list = new ArrayList();
        list.add("uno");
        list.add("due");
        list.add("tre");
        list.add("quattro");
        list.add(5);

        printRawCollStream(list);
        printCollStreamGenerics(list);

        Collection<String> c2 = new ArrayList<>();
        c2.addAll(list);
        printRawCollStream(c2);
        printCollStreamGenerics(c2);
        
        ArrayList<String> c3 = c2.stream().collect(Collectors.toCollection(ArrayList::new));
        printRawCollStream(c3);

        // Nämä on tämän esimerkin kannalta extraa!

        Collection<Object> unmodList = List.of("uno", "due","tree","quattro", 5);
        printRawCollStream(unmodList);

        //List<String> unmodList2 = List.of("uno", "due","tree","quattro", 5); // Does not work anymore
        Collection<String> unmodList2 = List.of("uno", "due","tree","quattro", "5");
        printRawCollStream(unmodList2);
        
    }
}
