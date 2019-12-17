package basic.basic2functional;

import java.util.Comparator;
import java.util.List;


public class SortByDistanceFunctionalDemo {

    public static Double calcDistance(int[] point) {

        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));

    }

    public static void main(String args[]) {

        List<int[]> coordinates = List.of(new int[] { 210, 30 },
                new int[] { 360, 350 }, new int[] { 30, 350 },
                new int[] { 190, 350 }, new int[] { 180, 450 },
                new int[] { 220, 450 });

        coordinates.stream().sorted(
                ((a, b) -> calcDistance(a).compareTo(calcDistance(b))))
                .forEach(coord -> {
                    Double distance = calcDistance(coord);
                    System.out.printf(
                            "(%3d, %3d): Distance from the origin: %.2f\n",
                            coord[0], coord[1], distance);
                });

        System.out.println("Another way to sort with method reference:");

        Comparator<int[]> pointComparator = (int[] a,
                int[] b) -> SortByDistanceFunctionalDemo.calcDistance(a)
                        .compareTo(SortByDistanceFunctionalDemo
                                .calcDistance(b));

        coordinates.stream().sorted(pointComparator).forEach(coord -> {
            Double distance = calcDistance(coord);
            System.out.printf(
                    "(%3d, %3d): Distance from the origin: %.2f\n",
                    coord[0], coord[1], distance);
        });

    }
}
