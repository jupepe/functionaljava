package optional;

import java.util.Arrays;
import java.util.Objects;

public class OptionalReduce {

    public static void calcReduceSum(int[] arr) {        
        Arrays.stream(arr).reduce((x,y) -> x+y).ifPresent(s -> System.out.println(s));
       }
    public static void calcReducePositiveSum(int[] arr) {        
        Arrays.stream(arr).filter(n -> n > 0).reduce((x,y) -> x+y).ifPresent(s -> System.out.println(s));
       }

    public static void calcReduceSum(Integer[] arr) {        
        //Arrays.stream(arr).reduce((x,y) -> x+y).ifPresent(s -> System.out.println(s));
        Arrays.stream(arr).filter(Objects::nonNull).reduce((x,y) -> x+y).ifPresent(s -> System.out.println(s));
       }

    public static void main(String[] args) {
        int[] arr1 = {15,25,35,50,-30,-50};
        Integer[] arr2 = {15,25,35,50,null};
        calcReduceSum(arr1);
        calcReducePositiveSum(arr1);
        calcReduceSum(arr2);
    }
    
}
