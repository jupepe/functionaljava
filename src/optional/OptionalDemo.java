package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class OptionalDemo {
    
    public static void optionalTests() {
        String str = "Hello Optional!";
        String nullStr = null;
     
        Optional<String> opt1 = Optional.of(str);                    
        Optional<String> opt2 = Optional.ofNullable(str);
        Optional<String> optNull1 = null; 
        try {
            optNull1 = Optional.of(nullStr);         // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("NullPointer - " + optNull1);
        }
        Optional<String> optNull2 = Optional.ofNullable(nullStr); 
     
        System.out.println(opt1.get());
        System.out.println(opt2.get());    
        
        System.out.println(optNull2.orElseGet(() -> "null")); 
        if(!optNull2.isPresent()) {
            System.out.println("Is empty");      
        }
    }

    public static void optionalDefaults() {
        Optional<String> jname = Optional.of("java se 8");
        Optional<String> upperName = jname.map(v -> v.toUpperCase());
        System.out.println(upperName.orElse("Null value found"));

        jname = Optional.ofNullable(null);
        upperName = jname.map(v -> v.toUpperCase());
        System.out.println(upperName.orElse("Null value found"));
        System.out.println(upperName);

    }

    public static void optionalFiltering() {
        Optional<String> test = Optional.of("thebook");
        Optional<String> shortName = test.filter(v -> v.length() > 10);
        System.out.println(
                shortName.orElse("The name is less than 10 characters"));

    }

    public static void optionalFilteringList() {
        final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name
                .startsWith(letter);

        List<String> names = Arrays.asList("Bob", "John", null, "Bill",
                "Bert");

        for (String name : names) {
            Optional<String> shortName = Optional.ofNullable(name)
                    .filter(startsWithLetter.apply("B"));
            System.out.print(shortName
                    .orElse("start with the letter other than 'B' "));
            System.out.print(" ");
            if (shortName.isPresent()) {
                System.out.println(shortName.get());
            } else {
                System.out.println("Value is not present - " + Optional
                        .ofNullable(name).orElseGet(() -> "null"));
            }
        }

    }

    public static void main(String[] args) {
        optionalTests();
        optionalDefaults();
        System.out.println("Optional Filtering");
        optionalFiltering();
        optionalFilteringList();

    }
}
