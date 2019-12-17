package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamFiltersDemo {

    public static void main(String[] args) {

        // Count the empty strings
        List<String> ducks = Arrays.asList("Duck, Donald", "Mouse, Mickey",
                "", null, "Goofy", "", "Black, Pete", "McDuck, Scrooge",
                "Duck, Louie", "Duck, Huey", "Duck, Dewey", "Duck, Daisy",
                "Gander, Gladstone");

        // Count empty string and filtering nulls before it
        long count = ducks.stream().filter(Objects::nonNull)
                .filter(name -> name.length() == 0).count();
        System.out.printf("List has %d empty strings \n", count);

        // String length more than 10
        count = ducks.stream().filter(Objects::nonNull)
                .filter(name -> name.length() > 10).count();
        System.out.printf("List has %d strings of length more than 10 \n",
                count);

        // Count number of String which startswith "D"
        count = ducks.stream()
                .filter(name -> name != null && name.startsWith("D"))
                .count();
        System.out.printf("List has %d strings which starts letter 'D' \n",
                count);

        // Remove all empty Strings from List
        List<String> filtered = ducks.stream()
                .filter(name -> name != null && !name.isEmpty())
                .collect(Collectors.toList());
        System.out.printf("Filtered List without Empty Strings : %s \n",
                filtered);

        // Convert filtered ducks to uppercase and join these to string
        String allDucks = filtered.stream().map(name -> name.toUpperCase())
                .filter(name -> name.contains("DUCK"))
                .map(name -> name.replaceAll(",", ""))
                .collect(Collectors.joining(", "));
        System.out.printf("Only ducks: %s\n", allDucks);

    }
}
