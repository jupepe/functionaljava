package functionalIface;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FunctionParamsDemo {

    public static String stringConversion(String s,
            Function<String, String> strFunc) {
        return strFunc.apply(s);
    }

    public static String join(String arr[], String delim) {
        return Arrays.asList(arr).stream()
                .collect(Collectors.joining(delim));
    }

    public static String joinWithBuilder(String arr[], String delim) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i] + delim);
        }
        return sb.toString() + arr[i];
    }

    public static void main(String args[]) {

        System.out.println("String conversions with Lambda expressions"
                + " as argument to function: ");

        Function<String, String> big = (s) -> s.toUpperCase();
        Function<String, String> small = String::toLowerCase;
        Function<String, String> rexp = (s) -> join(
                Pattern.compile("\\W").split(s), "-");
        Function<String, String> rexp2 = (s) -> joinWithBuilder(
                Pattern.compile("\\W").split(s), ".");

        String bigStr = stringConversion("lambda is great!", big);

        String smallStr = stringConversion("lambda is great!", small);
        String rejoin = stringConversion(
                "lambda.in+java8:was?a,great*new!+-*/feature", rexp);
        String rejoin2 = stringConversion(
                "lambda.in+java8:was?a,great*new!+-*/feature", rexp2);

        String smallStr2 = big.apply("Other way");

        System.out.println("After Lambda change -> " +  bigStr);
        System.out.println("After Lambda change -> " + smallStr);
        System.out.println("After Lambda change -> " + rejoin);
        System.out.println("After Lambda change -> " + rejoin2);
        System.out.println("After Lambda change -> " + smallStr2);

    }
}
