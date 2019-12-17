package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByDistanceDemo {

    public static Double calcDistance(int[] point) {

        double distance = Math
                .sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));

        return distance;

    }

    public static void main(String args[]) {
        ArrayList<int[]> coordinates = new ArrayList<>();
        coordinates.add(new int[] { 210, 30 });
        coordinates.add(new int[] { 360, 350 });
        coordinates.add(new int[] { 30, 350 });
        coordinates.add(new int[] { 190, 350 });
        coordinates.add(new int[] { 180, 450 });
        coordinates.add(new int[] { 220, 450 });
        coordinates.add(new int[] { 220, 350 });

        Collections.sort(coordinates, new Comparator<int[]>() {

            @Override
            public int compare(int[] a, int[] b) {
                return calcDistance(a).compareTo(calcDistance(b));
            }
        });

        for (int[] coord : coordinates) {
            Double distance = calcDistance(coord);
            System.out.printf("(%3d, %3d): Distance from the origin: %.2f\n", coord[0], coord[1], distance );
        }

    }
}
