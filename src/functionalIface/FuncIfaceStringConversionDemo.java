package functionalIface;

@FunctionalInterface
interface StringConversion {

    String convert(String s);
}

public class FuncIfaceStringConversionDemo {

    public static void main(String[] args) {
        System.out.println("String conversions with Lambda: ");

        StringConversion big = (String s) -> s.toUpperCase();
        StringConversion small = (String s) -> s.toLowerCase();

        String bigStr = big.convert("testing CONversion inTERface");
        String smallStr = small.convert("Another Test");

        System.out.println(bigStr);
        System.out.println(smallStr);
    }
}
