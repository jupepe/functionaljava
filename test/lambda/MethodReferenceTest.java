package lambda;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;

import org.junit.Test;

class UtilFunctions {

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static String operateString(Function<String, String> operator,
            String a) {
        return operator.apply(a);
    }

    public static int operateInt(IntBinaryOperator operator, int a, int b) {
        return operator.applyAsInt(a, b);
    }

}

public class MethodReferenceTest {
    @Test
    public void multiplyingTest() {
        Integer r1 = UtilFunctions.operateInt((a, b) -> a * b, 2, 5);
        Integer r2 = UtilFunctions
                .operateInt((a, b) -> UtilFunctions.multiply(a, b), 2, 5);
        Integer r3 = UtilFunctions
                .operateInt(UtilFunctions::multiply, 5, 2);
        assertEquals((Integer) 10, r1);
        assertEquals((Integer) 10, r2);
        assertEquals((Integer) 10, r3);
    }

    @Test
    public void callMethodWithClassName() {
        String r1 = UtilFunctions.operateString(s -> s.toLowerCase(),
                "Test");
        String r2 = UtilFunctions.operateString(String::toUpperCase,
                "test");
        String r3 = UtilFunctions.operateString(s -> s.repeat(5), "NO");
        assertEquals((String) "test", r1);
        assertEquals((String) "TEST", r2);
        assertEquals((String) "NONONONONO", r3);

    }

}