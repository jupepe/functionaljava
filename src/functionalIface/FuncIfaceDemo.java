package functionalIface;

@FunctionalInterface
interface WriterIface {

    public void write(String str);

    @Override
    public String toString();

}

@FunctionalInterface
interface MultiplyIface {

    public long count(int value);
    
}

public class FuncIfaceDemo {

    public static void main(String[] args) {
        WriterIface writerAnom = new WriterIface() {
            @Override
            public void write(String str) {
                System.out.println(str);
            }
        };
        WriterIface writerLambda = (str) -> System.out.println(str);
        printIfaceInfo(writerAnom, "Anonymous function");
        printIfaceInfo(writerLambda, "Lambda Expression");

        MultiplyIface tripleImpl = (n) -> Math.round(Math.pow(n, 3));
        MultiplyIface eightImpl = (n) -> Math.round(Math.pow(n, 8));
        System.out.println(tripleImpl.count(2));
        System.out.println(tripleImpl.count(3));
        System.out.println(eightImpl.count(2));
        System.out.println(eightImpl.count(4));

    }

    public static void printIfaceInfo(WriterIface fi, String str) {
        System.out.println("in printIfaceInfo(): " + str);
        fi.write(str);
    }
}
