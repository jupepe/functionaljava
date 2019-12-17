package basic.basic2functional;

import java.util.Arrays;

public class Int2DArraySortFunctionalDemo {

    public static void main(String args[]) {
        int[][] a2d = { { 10, 20 }, { 33, 7 }, { 30, 10 }, { 40, 12 },
                { 15, 30 } };

        Arrays.sort(a2d, (a, b) -> b[0] - a[0]);

        System.out.println(Arrays.deepToString(a2d));

    }
}
