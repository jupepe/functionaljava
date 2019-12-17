package basic;

public class CalculateFunctionsDemo {

    static final int LOWER = 1, UPPER = 10;

    public static void main(String argv[]) {
        int i = 0, k = 0;
        for (i = LOWER; i <= UPPER; i++) {
            int tmp = 0;
            for (k = LOWER; k <= UPPER; k++) {
                tmp = k * i;
                System.out.print(tmp + "\t");
            }
            System.out.println();
        }

    }
}
