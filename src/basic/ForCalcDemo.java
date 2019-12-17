package basic;

public class ForCalcDemo {

    public static int sum(int begin, int end) {
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static int multiply(int begin, int end) {
        int multiply = 1;
        int i = begin;

        while (i <= end) {
            multiply *= i;
            i++;
        }
        return multiply;
    }

    public static void main(String args[]) {

        int sum = sum(1, 10);
        int res = multiply(1, 10);

        System.out.println("sum 1-10 = " + sum);
        System.out.println("multiply 1-10 = " + res);

    }
}
