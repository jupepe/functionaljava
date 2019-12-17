package optional;

import java.util.Optional;

public class OptionalOrNullCheckDemo {

    public static String getValueOrDefault(String str) {
        return Optional.ofNullable(str).orElse("DefaultStr");
    }
    
    public static String getValueOrDefault2(String str) {
        return (str != null) ? str : "DefaultStr";
    }
    
    public static void main(String[] args) {
        String str = "Test";
        String nullStr = null;
        System.out.println(getValueOrDefault(str ));
        System.out.println(getValueOrDefault2(str));
        System.out.println(getValueOrDefault(nullStr ));
        System.out.println(getValueOrDefault2(nullStr));

    }

}
