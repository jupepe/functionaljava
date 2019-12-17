package functionalIface;

import static org.junit.Assert.assertEquals;

// Function, Supplier, Consumer jne.
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

class MethodReferenceExample {

    public int sum(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public String operateString(Function<String, String> operator,
            String a) {
        return operator.apply(a);
    }

    public int operateInt(IntBinaryOperator operator, int a, int b) {
        return operator.applyAsInt(a, b);
    }

}

public class FunctionalInterfaceTest {

    @Test
    public void usingFunctionInterface() {
        Function<String, String> convertFunction = String::toLowerCase;
        Function<String, Integer> lengthFunction = x -> x.length();
        // metodireferenssi
        @SuppressWarnings("unused")
        String r3 = convertFunction.apply("Test");
        assertEquals("test", r3);

        Integer t = lengthFunction.apply("KOETESTI");
        assertEquals((Integer) 8, t);
    }

    @Test
    public void usingSupplier() {
        // Lokaalia muuttujaa voi käyttää metodin sisällä
        String str = "This is Supplier";
        // Supplier<String> supplier = () -> "Supplier";
        Supplier<String> supplier = () -> str.substring(8);
        String r1 = supplier.get();
        assertEquals("Supplier", r1);
    }

    @Test
    public void usingConsumer() {
        Consumer<String> consumer = x -> System.out
                .println("From consumer:" + x.toUpperCase());
        consumer.accept("Change me");
        // test not possible because the return type is void
    }


    @SuppressWarnings("deprecation")
    @Test
    public void usingPredicate() {
        Predicate<Integer> predicate = x -> x > 10;
        Boolean r1 = predicate.test(new Integer(20));
        Boolean r2 = predicate.test(new Integer(5));
        assertEquals(true, r1);
        assertEquals(false, r2);

        // merkkijonon pituuden testaaminen
        Predicate<String> lowerTen = x -> x.length() < 10;
        Boolean tulos = lowerTen.test("Onko liian pitkä?");
        assertEquals(false, tulos);
    }

}
