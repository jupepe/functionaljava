package lambda;

import java.util.List;
import java.util.stream.Collectors;

public class HelloFunctionalStreams {

    // Traditional functions
    public static String sayHelloTraditional1(List<String> names) {
        String str = "Hi ";
        for (String name : names) {
            str += name + " ";
        }
        return str;
    }

    public static String sayHelloTraditional2(List<String> names) {
        StringBuilder builder = new StringBuilder();
        builder.append("Hi ");
        for (String name : names) {
            builder.append(name);
            builder.append(" ");
        }
        return builder.toString();
    }

    // Not pure functional way. Change state inside loop
    // depends on builder, no output
    public static String sayHelloTest1(List<String> names) {
        StringBuilder builder = new StringBuilder();
        names.stream().forEach(n -> builder.append(n).append(" "));
        return "Hi " + builder.toString();
    }

    // Functional implementations
    public static String sayHelloFunctional1(List<String> names) {
        return names.stream().map(name -> name + " ").reduce("Hi ",
                (old, newName) -> old + "," + newName);
    }

    public static String sayHelloFunctional2(List<String> names) {
        String namesStr = names.stream().collect(Collectors.joining(" "));
        return "Hi " + namesStr;
    }

    public static void main(String args[]) {
        List<String> ducks = List.of("Donald", "Mickey", "Goofy");
        System.out.println(sayHelloTraditional1(ducks));
        System.out.println(sayHelloTraditional2(ducks));
        System.out.println(sayHelloTest1(ducks));
        System.out.println(sayHelloFunctional1(ducks));
        System.out.println(sayHelloFunctional2(ducks));

    }

}
