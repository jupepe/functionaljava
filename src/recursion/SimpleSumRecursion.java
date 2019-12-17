package recursion;

public class SimpleSumRecursion {
    public static int recursiveSum(int n) {
//        System.out.println("n = " + n);
        if (n <= 1)
            return n;
        
        return n + recursiveSum(n - 1);
    }

    public static int recursiveArraySum(int[] arr, int n) {
        //System.out.println("n = " + n);
        if (arr.length <= 1)
            return arr[0];
        
        return arr[n-1] + recursiveSum(arr[n - 2]);
    }

    
    public static void main(String[] args) {
        System.out.println("recursiveSum(5)=" + recursiveSum(15000));
        int[] intArr = new int[] {1,2,3,4,5,6};
        System.out.println(recursiveArraySum(intArr, intArr.length));
    }

}
