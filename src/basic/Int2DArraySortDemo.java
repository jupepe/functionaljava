package basic;

import java.util.Arrays;
import java.util.Comparator;

public class Int2DArraySortDemo {

    public static void main(String args[]) {
        int[][] a2d = { { 10, 20 }, { 33, 7 }, { 30, 10 }, { 40, 12 },
                { 15, 30 } };

        Arrays.sort(a2d, new Comparator<int[]>() {

            @Override
            public int compare(int[] a, int[] b) {
                return (b[0] - a[0]);
            }
        });

        System.out.println(Arrays.deepToString(a2d));

    }
}
