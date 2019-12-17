package stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ConvertStreamsDemo {

    public static void convertToSet(String[] fruits) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(fruits));
        Stream<String> setStream = set.stream();
        System.out.println("Set stream");
        setStream.forEach(System.out::println);

    }

    public static void convertToList(String[] fruits) {
        List<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(fruits));

        Stream<String> listStream = list.stream();
        System.out.println("List stream");
        listStream.forEach(System.out::println);

    }

    public static void convertArray(String[] fruits) {

        Stream<String> arrayStream = Arrays.stream(fruits);
        System.out.println("Array Stream");
        arrayStream.forEach(System.out::println);

    }

    public static void main(String[] args) {
        String[] fruits = { "apple", "banana", "orange", "mango" };
        convertArray(fruits);
        convertToSet(fruits);
        convertToList(fruits);
    }
}
